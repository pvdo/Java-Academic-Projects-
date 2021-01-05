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

package concretClass.invoice;

import interfaces.payable.Payable;

public class Invoice implements Payable{

	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	
	public Invoice(String pNum, String pDesc, int qty, double price) {
		partNumber = pNum;
		partDescription = pDesc;
		quantity = qty;
		pricePerItem = price;
	}
	
	@Override
	public String toString() {
		return "Part Number: " + partNumber + "\nPart Description: " + partDescription + "\nQuantity: " + quantity
				+ "\nPrice Per Item: " + pricePerItem;
	}
	
	public double getPaymentAmount() {
		return getQuantity() * getPricePerItem();
	}
	
	
	
}
