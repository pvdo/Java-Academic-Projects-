/**********************************************
Workshop 8 - task 2
Course: JAC444 - 4th Semester
Last Name: Do Carmo Saraiva Teixeira
First Name: Pedro Vitor
ID: 100036193
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date: November 24, 2020
**********************************************/
public class ReverseThread extends Thread{

	int counter = 0;
	public ReverseThread(int count) {
		this.counter = count;
	}
	public void run() {
		if(counter < 51) {
			ReverseThread newThread = new ReverseThread(counter+1);
			newThread.start();
			
			try {
				newThread.join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			
			System.out.println("Hello from thread :" + counter );
		}
	}
	
	public static void main(String [] args) {
		ReverseThread newThread = new ReverseThread(1);
		newThread.start();
	}
}
