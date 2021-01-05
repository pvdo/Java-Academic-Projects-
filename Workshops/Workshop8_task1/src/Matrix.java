/**********************************************
Workshop 8 - task 1
Course: JAC444 - 4th Semester
Last Name: Do Carmo Saraiva Teixeira
First Name: Pedro Vitor
ID: 100036193
Section: NDD
This assignment represents my own work in accordance with Seneca Academic Policy.
Date: November 24, 2020
**********************************************/

import java.util.Date;
import java.util.Random;

public class Matrix{
	
	static int matrixSize = 2000;
	//Matrix examples
	static double matrixA[][] = new double [matrixSize][matrixSize];
	static double matrixB[][] = new double [matrixSize][matrixSize];
	//Random Number
	static double minNumber = 1;
	static double maxNumber = 2000;
	static Random random = new Random();
	
	
	public static double[][] parallelAddMatrix(double[][] a, double[][] b) throws InterruptedException{
		double parallelMatrix[][] = new double [matrixSize][matrixSize];
		int counter = 0;
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0; i < 500; i++) {
					for (int j = 0; j < 500; j++) {
						parallelMatrix[i][j] = a[i][j] + b[i][j];
						
					}
				}
				
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				for (int i = 501; i < 1000; i++) {
					for (int j = 501; j < 1000; j++) {
						parallelMatrix[i][j] = a[i][j] + b[i][j];
					}
				}
			}
		};
		Thread t3 = new Thread() {
			public void run() {
				for (int i = 1001; i < 1500; i++) {
					for (int j = 1001; j < 1500; j++) {
						parallelMatrix[i][j] = a[i][j] + b[i][j];
					}
				}
			}
		};
		Thread t4 = new Thread() {
			public void run() {
				for (int i = 1501; i < 2000; i++) {
					for (int j = 1501; j < 2000; j++) {
						parallelMatrix[i][j] = a[i][j] + b[i][j];
					}
				}
			}
		};
		
		
		
			t1.start();	
			t1.join();
			t2.start();
			t2.join();
			t3.start();
			t3.join();
			t4.start();
			t4.join();

			

		
		return parallelMatrix;
		
	}
	
	public static double[][] sequentialAddMatrix(double[][] c, double[][] d){
		
		double sequentialMatrix[][] = new double[matrixSize][matrixSize];
		
		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				sequentialMatrix[i][j] = c[i][j] + d[i][j];
			}
		}
		
		return sequentialMatrix;
		
	}
	
	public static void main (String [] args) throws InterruptedException {
		
		
				
		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				matrixA[i][j] = Math.round((random.nextDouble() * (maxNumber - minNumber))*100);
				matrixB[i][j] = Math.round((random.nextDouble() * (maxNumber - minNumber))*100);
			}
		}
		
		Date startSeq = new Date();
		double matrix1[][] = sequentialAddMatrix(matrixA, matrixB);
		Date endSeq = new Date();
		
		System.out.println("Sequential addition time in miliseconds: " + (endSeq.getTime() - startSeq.getTime()));
		
		Date startParal = new Date();
		double matrix2[][] = parallelAddMatrix(matrixA, matrixB);
		Date endParal= new Date();
		
		System.out.println("Parallel addition time in miliseconds: " + (endParal.getTime() - startParal.getTime()));
	}



}