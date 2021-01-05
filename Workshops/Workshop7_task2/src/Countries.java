/**********************************************
Workshop 7 - task 2
Course: JAC444 - 4th Semester
Last Name: Do Carmo Saraiva Teixeira
First Name: Pedro Vitor
ID: 100036193
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: November 16, 2020
**********************************************/
import java.io.RandomAccessFile;
import java.util.Scanner; 
import java.util.HashMap;
import java.util.Map;

public class Countries{
	
		public static void main(String [] args) {
			
			Map<String, String> countriesCap = new HashMap();
			Scanner input = new Scanner(System.in);
		
			try(RandomAccessFile raf = new RandomAccessFile("countries.txt", "rw")){
			
				String lineString;
				while((lineString = raf.readLine()) != null) {
					
					String [] listString = lineString.split("\t");
					countriesCap.put(listString[0], listString[1]);
					
				}
			
			}catch(Exception e) {
			
			}
			
			System.out.println("Enter a country: ");
			String country = input.next();
			
			
			System.out.println("The capital of " + country + " is " + countriesCap.get(country));
						
	}
	
}
