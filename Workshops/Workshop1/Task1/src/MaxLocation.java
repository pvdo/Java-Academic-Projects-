//Workshop 1 - TASK 1
//Course:JAC444 - 4 Semester
//Last Name: Do Carmo Saraiva Teixeira
//First Name: Pedro Vitor
//ID: 100036193
//Section: NDD
//This assignment represents my own work in accordance with Seneca Academic Policy. Signature
//Date: September 26, 2020


//FIND MAX VALUE OF A TWO_DIMESION ARRAY
import java.util.Scanner;
public class MaxLocation {
	

	
	public static void main(String[] args) {
		
		
		int row, column;
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of rows and columns in the array: ");
		
		//Input of row and column
		row = scan.nextInt();
		column = scan.nextInt();
		
		//Create the array with the values of the variables row and column
		double maxValue [] [] = new double [row] [column];
		
		System.out.println("Enter the array:" );
		//Get the input for each postion on the array
		//Rows
		for (int i = 0; i < row; i++) {
			//Columns
			for(int j = 0; j < column; j++) {
				maxValue[i][j] = scan.nextDouble();
			}
		}
		System.out.println("The location of the largest element is " + findMax(maxValue) + " at (" + findRow(maxValue) +
				"," + findColumn(maxValue) + ")");
		
	}
	
	//Method to find the Max value in the array
	public static double findMax(double [][] valuesArray) {
		double maxValue = valuesArray[0][0];
		//Row
		for(int i = 0; i < valuesArray.length; i++) {
			//Column
			for(int j = 0; j < valuesArray[i].length; j++) {
				//if the current max value is less than the value of the position i j
				if(maxValue < valuesArray[i][j]) {
					//replace the value of max value to the value of position i j
					maxValue = valuesArray[i][j];
				}
			}
		}
		return maxValue;
	}
	
	//Method to find the Column index number where the max value is storage
	public static int findColumn(double [][] valuesArray) {
		double maxValue = valuesArray[0][0];
		int column = 0;
		for(int i = 0; i < valuesArray.length; i++) {
			for(int j = 0; j < valuesArray[i].length; j++) {
				if(maxValue < valuesArray[i][j]) {
					column = j;
				}
			}
		}
		return column;
	}
	//Method to find the Row index number where the max value is storage
	public static int findRow(double [][] valuesArray) {
		double maxValue = valuesArray[0][0];
		int row = 0;
		for(int i = 0; i < valuesArray.length; i++) {
			for(int j = 0; j < valuesArray[i].length; j++) {
				if(maxValue < valuesArray[i][j]) {
					row = i;
				}
			}
		}
		return row;
	}

}
