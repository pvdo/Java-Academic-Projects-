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
package concretClass.employeeSubclasses;
import abstractClass.employee.Employee;

public class ComissionEmployee extends Employee {
	double grossSale;
	double comissionRate;
	public double getGrossSale() {
		return grossSale;
	}
	public void setGrossSale(double grossS) {
		checkGrossSale(grossS);
		this.grossSale = grossS;
	}
	public double getComissionRate() {
		return comissionRate;
	}
	public void setComissionRate(double comissionR) {
		checkComissionRate(comissionR);
		this.comissionRate = comissionR;
	}
	
	public ComissionEmployee(String fName, String lName, String ssn, double grossS, double comissionR){
		super(fName, lName, ssn);
		checkGrossSale(grossS);
		checkComissionRate(comissionR);
		this.grossSale = grossS;
		this.comissionRate = comissionR;
	}
	
	
	@Override
	public String toString() {
		return "COMISSION EMPLOYEE\n\n" + super.toString()
				+ "Gross Sale: " + String.format("$%,.2f", grossSale) + "\nComission Rate: " + comissionRate;
	}
	@Override
	public double getPaymentAmount() {
		
		return getGrossSale() * getComissionRate();
	}
	
	public void checkComissionRate(double comissionR) {
		if(comissionR < 0 || comissionR > 1) {
			throw new IllegalArgumentException("Comission Rate must be greater than 0 and less than 1");
		}
	}
	
	public void checkGrossSale(double grossS) {
		if(grossS <= 0) {
			throw new IllegalArgumentException("Gross Sale must be great than 0");
		}
	}
	
	
	
}
