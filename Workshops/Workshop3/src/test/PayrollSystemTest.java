/**********************************************
Workshop 3
Course: JAC444 - 4th Semester
Last Name: Do Carmo Saraiva Teixeira
First Name: Pedro Vitor
ID: 100036193
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: October 10, 2020
**********************************************/

package test;

import java.util.Scanner;

import abstractClass.employee.Employee;
import concretClass.employeeSubclasses.ComissionEmployee;
import concretClass.employeeSubclasses.HourlyEmployee;
import concretClass.employeeSubclasses.SalariedEmployee;
import concretClass.invoice.Invoice;
import concreteClass.comissionEmployeeSubclass.BasePlusComissionEmployee;

public class PayrollSystemTest {
	
		public static void main (String []args  ) {
			Scanner input = new Scanner(System.in);
			
			
			ComissionEmployee comissionEmployee = new ComissionEmployee("Sarah", "Miller", "222-22-2222", 2000, 0.8);
			BasePlusComissionEmployee basePlusEmployee = new BasePlusComissionEmployee("Hayle", "Dunphy", "333-33-3333", 1300, 0.6, 1500);
			HourlyEmployee hourlyEmployee = new HourlyEmployee("Jake", "Johnson", "000-00-0000", 30, 60.50);
			SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 1500.00);
			
			
			System.out.println("------------------");
			System.out.println("|EMPLOYEE PAYABLE|");
			System.out.println("------------------\n\n");
			
			System.out.println("-----------------------------------------------------");
			System.out.println("|First Test: Print employee information individually|");
			System.out.println("-----------------------------------------------------\n\n");
			System.out.println("**********************\n");
			System.out.printf( "%s\n%s: $%,.2f\n\n", comissionEmployee, "earned",
					comissionEmployee.getPaymentAmount() );
			System.out.println("**********************\n");
			System.out.printf( "%s\n%s: $%,.2f\n\n", basePlusEmployee, "earned",
					basePlusEmployee.getPaymentAmount() );
			System.out.println("**********************\n");
			System.out.printf( "%s\n%s: $%,.2f\n\n", hourlyEmployee, "earned",
					hourlyEmployee.getPaymentAmount() );
			System.out.println("**********************\n");
			System.out.printf( "%s\n%s: $%,.2f\n\n", salariedEmployee, "earned",
					salariedEmployee.getPaymentAmount() );
			System.out.println("**********************\n");
			
			
			System.out.println("\n------------------------------------------------------------------");
			System.out.println("Second Test: Print information about each object polymorphically.|");
			System.out.println("------------------------------------------------------------------\n\n");
			
			Employee [] employees = {comissionEmployee, basePlusEmployee, hourlyEmployee, salariedEmployee};
			for(int i = 0; i < employees.length; i++) {
				System.out.println("**********************\n");
				if(employees[i] instanceof ComissionEmployee) {
					System.out.printf("%s\n%s: $%,.2f\n\n", (ComissionEmployee)employees[i], "earned",
							((ComissionEmployee)employees[i]).getPaymentAmount());
				}
				else if(employees[i] instanceof BasePlusComissionEmployee) {
					System.out.printf("%s\n%s: $%,.2f\n\n", (BasePlusComissionEmployee)employees[i], "earned",
							((BasePlusComissionEmployee)employees[i]).getPaymentAmount());
				}
				else if(employees[i] instanceof HourlyEmployee) {
					System.out.printf("%s\n%s: $%,.2f\n\n", (HourlyEmployee)employees[i], "earned",
							((HourlyEmployee)employees[i]).getPaymentAmount());
				}
				else if(employees[i] instanceof SalariedEmployee) {
					System.out.printf("%s\n%s: $%,.2f\n\n", (SalariedEmployee)employees[i], "earned",
							((SalariedEmployee)employees[i]).getPaymentAmount());
				}
			}
			System.out.println("**********************\n");
			
			System.out.println("\n----------------------------------------------------------");
			System.out.println("|Third Test: Find out the specific class for each object.|");
			System.out.println("----------------------------------------------------------\n");
			for(int i = 0; i < employees.length; i++) {
				System.out.println(employees[i].getClass());
			}
			
			System.out.println("\n----------------------------------------------------------");
			System.out.println("|Extra Test: Invoice test.|");
			System.out.println("----------------------------------------------------------\n");
			
			System.out.println("Enter Part Number: ");
			String partNum = input.next();
			System.out.println("Enter Part Description: ");
			String desc = input.next();
			System.out.println("Enter Quantity: ");
			int quant = input.nextInt();
			System.out.println("Enter Price per Item: ");
			double pricePerI = input.nextDouble();
			
			Invoice invoice = new Invoice(partNum, desc, quant, pricePerI);
			
			System.out.printf( "\n%s\n%s: $%,.2f\n\n", invoice, "Total Cost",
					invoice.getPaymentAmount() );
			
		}	
}
