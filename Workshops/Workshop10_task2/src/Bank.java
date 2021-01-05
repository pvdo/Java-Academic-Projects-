//REFLECT - Workshop 10
//Course:JAC444 - 4 Semester
//Last Name: Do Carmo Saraiva Teixeira
//First Name: Pedro Vitor
//ID: 100036193
//Section: NDD
//This assignment represents my own work in accordance with Seneca Academic Policy.
//Date: December 08, 2020

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Bank {
	
	static int  idCounter = 0;
	private int id;
	private double balance;
	private ArrayList<Loanee> loanees; //lend money
	private ArrayList<Loanee> loaners; //borrow money
	private double assets;
//	private int liability;
//	private int balanceSheet;
	private boolean unsafe;
	
	Bank(){
		id = idCounter;
		idCounter++;
		loanees = new ArrayList<Loanee>();
		loaners = new ArrayList<Loanee>();
		setUnsafe(false);
	}
	
	public int getId() {
		return this.id;
	}
	public double getBalance() {
		return this.balance;
	}
//	public int getBalanceSheet() {
//		return this.balanceSheet;
//	}
	public double getAssets() {
		return this.assets;
	}
//	public int getLiability() {
//		return this.liability;
//	}

	public boolean isUnsafe() {
		return unsafe;
	}

	public void setUnsafe(boolean unsafe) {
		this.unsafe = unsafe;
	}
	
	public void setBalance(int m_balance) {
		this.balance = m_balance;
	}
	
	public void addLoanees(int id, double amountLoaned) {
		Loanee loanee = new Loanee(id, amountLoaned);
		this.loanees.add(loanee);
	}
	public void addLoanners(int id, double amount) {
		Loanee loaner = new Loanee(id, amount);
		this.loaners.add(loaner);
	}

	public void calculateBalance(){
		if(!isUnsafe()) {
			this.assets = this.balance;
			if(!this.loanees.isEmpty()) {
				for(Loanee loanee : loanees) {
					if(!loanee.isbankrupted())
					this.assets += loanee.getAmountLoaned();
				}
			}
			
		}
	}
	
	public boolean isUnsafe(int limit){
		

		return this.assets < limit? true : false;
		
	}
	
//	public boolean gotBankrupted() {
//		return this.assets <= 0? true : false;
//	}
	
	public void printInfo() {
//		For Bank # 4
//		Balance: 181
//		Number of banks Loaned: 1
//		Bank ID who gets the Loaned Amount: 125
		System.out.println("For Bank # " + this.id);
		System.out.println("Balance: " + this.balance);
		if(!this.loanees.isEmpty()) {
			System.out.println("Number of banks Loaned:" + this.loanees.size());
			for(Loanee loanee : this.loanees) {
				System.out.println("Bank ID who gets the loan: " + loanee.getId());
				System.out.println("Loaned Amount: " + loanee.getAmountLoaned());
			}
		}
		System.out.println("\n");
		
	}
	
// ------------------MAIN---------------------------	
	public  static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		int numberOfBanks;
		int minimumLimit;
		List<Bank> banks = new ArrayList<Bank>();
		boolean hasLoaned;
		
		System.out.print("Number of Banks: ");
		numberOfBanks = input.nextInt();
		
		System.out.print("Minimum asset limit: ");
		minimumLimit = input.nextInt();
		
		//CREATE BANKS
		for(int i = 0; i < numberOfBanks; i++) {
			
			Bank newBank = new Bank();
			System.out.println("Bank #" + i);
			System.out.print("Bank Balance(in million): ");
			newBank.setBalance(input.nextInt());
			banks.add(newBank);
		}
		
		//ADD LOANEE TO THE BANK LOANER/ AND THE LOANERS TO THE LOANEE BANK
		for(Bank bank : banks) {
			System.out.println("Bank #" + bank.getId());
			System.out.println("Does this bank has loaned money(true/false)");
			hasLoaned = input.nextBoolean();
			
			if(hasLoaned == true) {
				boolean more = true;
				int l_id;
				double l_amountLoaned;
				boolean found = false;
				
				do {
					
					//Get Loanee ID from the user
					System.out.println("Id of the loanee: ");
					l_id = input.nextInt();
					for(Bank bankCheck : banks){
						if(bankCheck.getId() == l_id) {
							found = true;
						}
					}
					if(!found) {
						System.out.println("Bank ID not found!");
					}else {
					
						//Get amount loaned from the user
						System.out.println("Amount of money loaned: ");
						l_amountLoaned = input.nextDouble();
						
						//Create
						bank.addLoanees(l_id, l_amountLoaned);
						
						//add loaner to the loanee bank
						banks.get(l_id).addLoanners(bank.getId(), l_amountLoaned);
						
						
					}
					System.out.println("Bank " + bank.getId() + " has more loanees? ");
					more = input.nextBoolean();
					found = false;
					
				}while(more == true);
			}
			bank.calculateBalance();
			
		}
		
		
		//Print all the banks in the ArrayList
		System.out.println("\nSUMMARY");
		for(Bank bank : banks) {
			bank.printInfo();
		}
		
		//Notify bankrupted banks
		int allBanksUpdated = 0;
		do {		
			for(Bank bank : banks) {
				if(bank.isUnsafe(minimumLimit)) {
					for(Bank bank2 : banks) {
						for(Loanee loanee : bank2.loanees) {
							if(bank.getId() == loanee.getId()) {
								loanee.setIsbankrupted(true);
							}
						}
					}
				}
			}
			for(Bank bank : banks) {
				bank.calculateBalance();
			}
			
			allBanksUpdated++;

		}while(allBanksUpdated <= numberOfBanks);
		

		
		//Check Unsafe Bank
		ArrayList<Bank> unsafeList = new ArrayList<Bank>();
		//ArrayList<Bank> bankruptedList = new ArrayList<Bank>();
		
		//ADD BANKS TO THE BANKRUPTED LIST
		for(Bank bank : banks) {
			if(bank.isUnsafe(minimumLimit)) {
				unsafeList.add(bank);
			}
		}
		
		//ADD BANKS TO THE UNSAFE LIST
		if(unsafeList.size() > 1) {
			System.out.print("Unsafe banks are: ");
		}else {
			System.out.print("Unsafe bank is: ");
		}
		
		for(Bank unsafeBank : unsafeList) {
			System.out.print("Bank " + unsafeBank.getId());
			if(unsafeBank.getId() == unsafeList.get(unsafeList.size() - 1).getId()) {
				System.out.print(".");
			}else {
				System.out.print(", ");
			}
			
		}
		System.out.println("\n");
//		Bank 3 got bankrupted and it got the loan from Bank 1,
//		because Bank 3 is unsafe due to under the limit Bank 1 is also unsafe due to lower limit.
		
		for(Bank unsafeBank : unsafeList) {
			System.out.print("Bank " + unsafeBank.getId() + " got bankrupted and it got the loan from: ");
			for(Loanee loaner : unsafeBank.loaners){
				System.out.print("Bank " + loaner.getId());
				if(loaner.getId() == unsafeBank.loaners.get(unsafeBank.loaners.size() - 1).getId()) {
					System.out.println(".");
				}else {
					System.out.print(", ");
				}
			}
		}
		
		System.out.println("\n");
		
		for(Bank unsafeBank : unsafeList) {
			for(Loanee loanee : unsafeBank.loanees) {
				if(loanee.isbankrupted()) {

					System.out.print("Because bank " + loanee.getId() + ", ");
					System.out.print("was bankrupted, Bank " + unsafeBank.getId() + " is also unsafe. \n");
					
				}
				
				
			}
			
		}
	}



}
