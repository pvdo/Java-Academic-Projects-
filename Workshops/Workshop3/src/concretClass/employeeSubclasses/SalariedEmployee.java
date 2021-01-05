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

public class SalariedEmployee extends Employee{
	double weeklySalary;
	
	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		this.weeklySalary = weeklySalary;
	}

	public SalariedEmployee(String fName, String lName, String ssn, double weeklySal) {
		super(fName, lName, ssn);
		
		this.weeklySalary = weeklySal;
	}
	
	
	
	@Override
	public String toString() {
		return "SALARIED EMPLOYEE\n\n" + super.toString() 
				+ "Weekly Salary: " + String.format("$%,.2f", weeklySalary);
	}

	@Override
	public double getPaymentAmount() {
		return getWeeklySalary();
	}

}
