import java.io.*;
import java.util.Scanner;

/**********************************************
Workshop 4
Course: JAC444 - 4th Semester
Last Name: Do Carmo Saraiva Teixeira
First Name: Pedro Vitor
ID: 100036193
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: October 19, 2020
**********************************************/


public class LettersCounter {
	
	
	
	public static void main (String [] args) {
		
		System.out.println("---------------------");
		System.out.println("| THE LETTER COUNTER |");
		System.out.println("---------------------");
		
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the name of the file: ");
		String fileName = input.next();
		File userFile = new File(fileName);
		
		
		//TRY-WITH-RESOURCE; NO NEED TO CLOSE THE FILES
			
		try(BufferedReader reader = new BufferedReader(new FileReader(userFile));){
		    
		    int ch;
		    char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTYVWXYZ".toCharArray();
		    int []counter = new int[alphabet.length];
		    while((ch=reader.read()) != -1) {
		    	for(int i=0; i < alphabet.length; i++) {
		    		if(alphabet[i] == (char)ch) {
		    			counter[i]++;
		    			i = alphabet.length;
		    		}
		        }
		    	
		    };
		    for(int i=0; i < alphabet.length; i++) {
		    	System.out.println(alphabet[i] + ":" + counter[i]);
		    }

		    
			
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
		
}