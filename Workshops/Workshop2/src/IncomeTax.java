/**********************************************
Workshop 2
//Course:JAC444 - 4 Semester
//Last Name: Do Carmo Saraiva Teixeira
//First Name: Pedro Vitor
//ID: 100036193
//Section: NDD
//This assignment represents my own work in accordance with Seneca Academic Policy. Signature
//Date: October 04, 2020
 */

import java.util.Scanner;

public class IncomeTax {
	final static int SINGLE_FILER = 0;
	final static int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
	final static int MARRIED_SEPARATELY = 2;
	final static int HEAD_OF_HOUSEHOLD = 3; 
	
	int filingStatus;
	int intervals[][];
	double rates[];
	double taxableIncome;
	
	//filingStatus 
	int getFilingStatus() {
		return filingStatus;
	}
	 void setFilingStatus(int p_Status) {
		filingStatus = p_Status;
	}
	
	//intervals
	int [][]getIntervals() {
		return intervals;
	}
	void setIntervals(int [][] p_Intervals){
		intervals = p_Intervals;
	}
	
	//rates
	double [] getRates() {
		
		return rates;
	}
	
	void setRates(double [] p_Rates) {
		rates = p_Rates;
	}
	
	//taxableIncome
	double getTaxableIncome(){
		return taxableIncome;
	}
	
	void setTaxableIncome(double p_TaxableIncome) {
		taxableIncome = p_TaxableIncome;
	}
	
	//no-args Contructor
	public IncomeTax() {};
	
	//args Constructor
	public IncomeTax(int p_filingStatus, int [][]p_intervals, double[]p_rates, double p_taxableIncome) {
		setFilingStatus(p_filingStatus);
		setIntervals(p_intervals);
		setRates(p_rates);
		setTaxableIncome(p_taxableIncome);
	};
	
	
	double calculateTax() {
		double tax = 0;
		double tempIncome = this.taxableIncome;
		for(int i = 0; i < this.intervals[filingStatus].length && tempIncome > 0; i++ ) {
			if(tempIncome > this.intervals[filingStatus][i]) {
				//tax from max interval value;
				tax += this.intervals[filingStatus][i] * (this.rates[i] /100);
				tempIncome -= this.intervals[filingStatus][i];
			}else {
				//tax from the remaing value
				tax += tempIncome * (this.rates[i] /100);
				tempIncome = 0;
			}
		}
			
		return tax;
	}
	
	public static void main (String [] args) {
		

		
		Scanner input = new Scanner(System.in);
		
		//intervals value for each year
		//Column = filing status
		//Row = max for each tax
		int [][]interval2001 = {{27050, 65550, 136750, 297350},
				{45200, 109250, 166500, 297350},
				{22600, 54625, 83250, 148675},
				{36250, 93650, 151650, 297350}
		};
		

		int [][]interval2009 = {{8350 , 33950, 82250, 171550, 372950},
				{16700, 67900, 137050, 208850, 372950},
				{8350, 33950 , 68525 , 104425, 186475},
				{11950, 45500, 117450, 190200, 372950}
		};
		
		//rates vairables
		double [] rates2001 = {15, 27.5, 30.5, 35.5, 39.1};
		double [] rates2009 = {10, 15, 25, 28, 33, 35};
		
		//Start print out
		
		System.out.println("Please select one of the options:\n"
				+ "1 - Calculate the tax of one income value\n"
				+ "2 - Calculate the tax of a range of value (the value will be calculate from 1000 to 1000)");
		
		int option = input.nextInt();
		
		while(option != 1 && option != 2) {
			System.out.println("Option not valid!\n"
					+ "Please select one of the options:\n"
					+ "1 - Calculate the tax of one income value\n"
					+ "2 - Calculate the tax of a range of value (the value will be calculate from 1000 to 1000)");
			 option = input.nextInt();
		}
		
		if(option == 1) {
			System.out.println("Please select on of the following options.");
			
			System.out.println("0 - single filer/n"
					+ "1 - married jointly or qualifying widow(er)/n"
					+ "2 - married separately/n"
					+ "3 - head of household/n");
			
			System.out.println("Enter the filing status: ");
			int fStatus = input.nextInt();
			
			System.out.println("Enter the Taxable Income: ");
			int tIncome = input.nextInt();
			
			IncomeTax iTax = new IncomeTax(fStatus, interval2009, rates2009, tIncome);
			
			
			System.out.println("Tax is: $" + iTax.calculateTax());
			
		}else {
			
			System.out.println("Enter the amount from: ");
			int amountFrom = input.nextInt();
			
			System.out.println("Enter the amount To: ");
			int amountTo = input.nextInt();
			
			System.out.println("2001 tax tables for taxable income from $" + amountFrom + " to $" + amountTo);
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-20s %-20s %-40s %-20s %-20s", "TAXABLE INCOME",
					"SINGLE",
					"MARRIED JOINT OR QUALIFYING WIDOW(ER)",
					"MARRIED OR SEPARATE",
					"HEAD OF A HOUSE");
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			
			int status = 0;
			double income = amountFrom;
			double singleTax = 0;
			double jointOrWidowTax = 0;
			double marriedTax = 0;
			double headHouseTax = 0;
			
			//2001
			IncomeTax iTax = new IncomeTax(status, interval2001, rates2001, income);
			
			while(income <= amountTo) {
				iTax.setTaxableIncome(income);
				iTax.setFilingStatus(status + SINGLE_FILER);
				singleTax = iTax.calculateTax();
				
				iTax.setFilingStatus(status + MARRIED_JOINTLY_OR_QUALIFYING_WIDOW);
				jointOrWidowTax = iTax.calculateTax();
				
				iTax.setFilingStatus(status + MARRIED_SEPARATELY);
				marriedTax = iTax.calculateTax();
				
				iTax.setFilingStatus(status + HEAD_OF_HOUSEHOLD);
				headHouseTax = iTax.calculateTax();
				
			        System.out.format("%-20s %-20s %-40s %-20s %-20s",
			                income, singleTax, jointOrWidowTax, marriedTax, headHouseTax);
			        System.out.println();
			        
			        income += 1000;
			}
			System.out.println();
			
			//Reset income
			income = amountFrom;
			status = 0;
			
			//2009
			System.out.println("2009 tax tables for taxable income from $" + amountFrom + " to $" + amountTo);
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-20s %-20s %-40s %-20s %-20s", "TAXABLE INCOME",
					"SINGLE",
					"MARRIED JOINT OR QUALIFYING WIDOW(ER)",
					"MARRIED OR SEPARATE",
					"HEAD OF A HOUSE");
			
			System.out.println();
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			
			while(income <= amountTo) {
				iTax.setIntervals(interval2009);
				iTax.setRates(rates2009);
				iTax.setTaxableIncome(income);
				
				iTax.setFilingStatus(status + SINGLE_FILER);
				singleTax = iTax.calculateTax();
				
				iTax.setFilingStatus(status+MARRIED_JOINTLY_OR_QUALIFYING_WIDOW);
				jointOrWidowTax = iTax.calculateTax();
				
				iTax.setFilingStatus(status+MARRIED_SEPARATELY);
				marriedTax = iTax.calculateTax();
				
				iTax.setFilingStatus(status+HEAD_OF_HOUSEHOLD);
				headHouseTax = iTax.calculateTax();
				
			        System.out.format("%-20s %-20s %-40s %-20s %-20s",
			                income, singleTax, jointOrWidowTax, marriedTax, headHouseTax);
			        System.out.println();
			        
			        income += 1000;
			}
		}
		
		
	}
}
