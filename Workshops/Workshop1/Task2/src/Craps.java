//Workshop 1 - TASK 2
//Course:JAC444 - 4 Semester
//Last Name: Do Carmo Saraiva Teixeira
//First Name: Pedro Vitor
//ID: 100036193
//Section: NDD
//This assignment represents my own work in accordance with Seneca Academic Policy. Signature
//Date: September 26, 2020



public class Craps {

	public static void main(String[] args) {
		//Roll the dices
		int dice1 = rollDice();
		int dice2 = rollDice();
		int diceSum = dice1 + dice2;
		
		System.out.println("You rolled " + dice1 + " + "+ dice2 + " = " + diceSum);
		
		//Sum of 2, 3 or 12 lose the game
		if(diceSum == 2 || diceSum == 3 || diceSum == 12) {
			System.out.println("Craps, Better Luck Next Time, You lose");
		//Sum of 7 or 11 win the game
		}else if(diceSum == 7 || diceSum == 11){
			System.out.println("Congratulations, You win");
		//Any other sum will create a Point determining the new winning value
		}else {
			int point = diceSum;
			System.out.println("Point is (established) set to " + point);
			do {
				//Reroll the dices
				dice1 = (int) rollDice();
				dice2 = (int) rollDice();
				diceSum = dice1 + dice2;
				System.out.println("You rolled " + dice1 + " + "+ dice2 + " = " + diceSum);
			}
			//if the sum is not 7 or the Point reroll the dices
			while(diceSum != 7 && diceSum != point);
			
			//if the sum is 7 lose game
			if(diceSum == 7) {
				System.out.println("Craps, Better Luck Next Time, You lose");
			}
			//if sum is point win the game
			if(diceSum == point) {
				System.out.println("Congratulations, You win");
			}
		}
		
	}
	
	public static int rollDice() {
		
		//The range of the dice is 1 to 6
		
		return (int) (1 + (Math.random() * 6));
	}
}
