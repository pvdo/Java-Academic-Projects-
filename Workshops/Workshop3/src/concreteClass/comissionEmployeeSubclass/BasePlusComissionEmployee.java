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

package concreteClass.comissionEmployeeSubclass;
import concretClass.employeeSubclasses.ComissionEmployee;

public class BasePlusComissionEmployee extends ComissionEmployee{
	double baseSalary;
	
	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public BasePlusComissionEmployee(String fName, String lName, String ssn, double grossS, double comissionR, double baseSal) {
		super(fName, lName, ssn, grossS, comissionR);
		checkbaseSalary(baseSal);
		this.baseSalary = baseSal;
	}
	
	@Override
	public double getPaymentAmount() {
		
		return (getBaseSalary() * 0.1) + (super.getPaymentAmount());
	}
	
	@Override
	public String toString() {
		return "BASE PLUS " + super.toString() + "\nBase Salary: " + String.format("$%,.2f", baseSalary);
	}

	public void checkbaseSalary(double baseSal) {
		if( baseSal <= 0) {
			throw new IllegalArgumentException("Base Salary must be greater than 0");
		}
	}
}
