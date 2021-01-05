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

package abstractClass.employee;

import interfaces.payable.Payable;

public abstract class Employee implements Payable{
	
	private String firstName;
	private String lastName;
	private String socialInsuranceNumber;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSocialInsuranceNumber() {
		return socialInsuranceNumber;
	}
	public void setSocialInsuranceNumber(String socialInsuranceNumber) {
		this.socialInsuranceNumber = socialInsuranceNumber;
	}
	
	public Employee(String fName, String lName, String ssn) {
		firstName = fName;
		lastName = lName;
		socialInsuranceNumber = ssn;
	}
	
	@Override
	public String toString() {
		return  "Employee: " + firstName + " " + lastName
				+ "\n"
				+ "SIN: " + socialInsuranceNumber + "\n";
	}
	
	
	

}
