import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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


public class hangman {
	
	
	
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		File hangmanFile = new File("hangman.txt");
		System.out.println("---------------");
		System.out.println("| THE HANGMAN |");
		System.out.println("---------------");
		
		//TRY-WITH-RESOURCE; NO NEED TO CLOSE THE FILES
			//FILEINPUTSTREAM TO READ THE WORD FROM THE DOCUMENT
		try(FileInputStream fin = new FileInputStream(hangmanFile);
				//FILEOUTPUTSTERAM TO WRITE INTO THE DOCUMENT; TRUE MEANS THAT IT WILL APPEND NEW WORDS
				FileOutputStream fout = new FileOutputStream(hangmanFile, true);
				//NO NEED TO CONVERT BYTES TO CHAR
				PrintWriter pwriter = new PrintWriter(fout);) {

			//BUFFER TO READ EACH LINE
			BufferedReader bin = new BufferedReader(new InputStreamReader(fin));

			char exit = 'y';
			//KEEP THE USER IN THE PROGRAM, UNLESS THE USER ENTER Y
			while(exit != 'n' && exit != 'N') {
				
				String word = null;
				int wordCounter = 0;
				int mistakes = 5;
				String guess;
				ArrayList<String> lettersGuessed = new ArrayList<>();
				
				bin = new BufferedReader(new InputStreamReader(new FileInputStream(hangmanFile)));
				//Discover how many words there is in the file
				while((word = bin.readLine()) != null){
					
					wordCounter++;
				}
				bin.close();
				//REOPEN FILE TO BUFFER
				bin = new BufferedReader(new InputStreamReader(new FileInputStream(hangmanFile)));
				String allWords [] = new String[wordCounter];
				wordCounter = 0;
				
				while((word = bin.readLine()) != null){
					allWords[wordCounter] = word;
					wordCounter++;
				}
				
				
				//GRAB ONE WORD FROM THE ARRAY RANDOMLY
				int randomIndex = new Random().nextInt(allWords.length);
				
				
				
				System.out.println("WARNING: You can only have " + mistakes + " mistakes" + " after that you will be hanged!!!! So the letters WISELY!\n");
				System.out.println("Let's Begin!\n");
				System.out.println("Your word have " + allWords[randomIndex].length() + " letters");
				char[] asterisk = allWords[randomIndex].replaceAll(".","*").toCharArray();
				boolean won = false;
				
				
				while(mistakes > 0 && won != true) {
					boolean letterFound = false;

					System.out.println(mistakes + " mistakes remaning");
					System.out.println("Word: " + new String(asterisk) );
					boolean sameLetter = false;
					
					do {
						
						System.out.println("Enter a letter: ");
						guess = input.next();
						if(lettersGuessed.contains(guess)) {
							System.out.println("You already guessed this letter!! Try again");
							sameLetter = true;
						}else {
							lettersGuessed.add(guess);
							sameLetter = false;
						}
					}while(sameLetter == true);
					
					
					for (int i=0;i < allWords[randomIndex].length();i++) {
					    if ((guess.charAt(0) == allWords[randomIndex].charAt(i))){
					        asterisk[i] = guess.charAt(0);
					        letterFound = true;
					    }
					    
					}
					if(letterFound == true) {
						System.out.println("YOU GOT A LETTER! You are a lucky individual!!\n");
					}else {
				    	System.out.println("How unfortunate!\n");
				    	mistakes--;
					}
					if((Arrays.equals(allWords[randomIndex].toCharArray(), asterisk))) {
						won = true;
						System.out.println("YOU WON! YOU WILL NOT BE HANGED THIS TIME!");
					}else if(mistakes == 0){
						System.out.println("YOU LOSE! THAT IS IT!GOODBYE");
					}
					
				}
				
								
				
				System.out.println("");
				System.out.println("------------------------");
				System.out.println("| ADD A WORD TO THE GAME|");
				System.out.println("------------------------");
				//ADD A WORD
				System.out.print("Write a word to add in our hangman game: ");
				//DECLARE/DEFINE NEW WORD
				String newWord = input.next();
				//WRITE INTO THE DOCUMENT HANGMAN.TXT
				pwriter.write("\n" + newWord);
				//FLUSH TO HANGMAN.TXT
				pwriter.flush();
				
				
				//ASK IF THE USER WANNA PLAY AGAIN
				do {
					System.out.println("Play Again? (Enter y or n)");
					exit = input.next().charAt(0);
				}
				while(exit != 'y' && exit != 'Y' && exit != 'n' && exit != 'N');
				
				bin.close();
			}
			
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
}
