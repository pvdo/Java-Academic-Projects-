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

public class HourlyEmployee extends Employee{
	double wage;
	double hours;
	
	public double getWage() {
		return wage;
	}

	public void setWage(double wag) {
		checkWage(wag);
		this.wage = wag;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hour) {
		checkHours(hour);
		this.hours = hour;
	}

	public HourlyEmployee(String fName, String lName, String ssn, double wag, double hour ) {
		super(fName, lName, ssn);
		checkWage(wag);
		checkHours(hour);
		this.wage = wag;
		this.hours = hour;
	}

	@Override
	public double getPaymentAmount() {
		double wageTotal;
		double extraHours;
		if(getHours() > 40) {
			extraHours = getHours() - 40;
			wageTotal = (40 * getWage()) + (extraHours * (getWage() * 1.5));
		}else {
			wageTotal = (hours * getWage());
		}
		return wageTotal;
	}

	@Override
	public String toString() {
		return "HOURLY EMPLOYEE\n\n" + super.toString() 
				+ "Wage: " + String.format("$%,.2f", wage) + "\nHours: " + hourFormat(hours);
	}
	
	
	public void checkHours(double hour) {
		if(hour < 0 || hour > 168) {
			throw new IllegalArgumentException("Hours must be greater than 0 and less than 168");
		}
	}
		
	public void checkWage(double wag) {
		if(wag <= 0) {
			throw new IllegalArgumentException("Wage must be greater than 0");
		}
	}
	
	public String hourFormat(double time){
		double minutes;
		int hours = (int) time;
		minutes = (time - hours) * 60;
		
		return hours + ":" + String.format("%02.0f", minutes);
	}
}
