package Assignments;

import java.util.Arrays;
import java.util.Random;
/*-will multiply and add 2 matrices
 * 1.Prompt the user for the dimensions of 2 matrices,
 * then check them for compatibility~if not compatible
 * then prompt the user again.
 * 2. fill the matrices w/ random generated numbers from 
 * ranging from 1 to 30, then display both
 * 3.Multiply the matrices and display the result, insert a
 * clock to see how long it takes
 * 4.Add the matrices and display the result, insert a clock
 * to see how long it takes
 * 5.Ask the user if they wish to repeat the program
 * 
 * 
 * 
 * start clock
 * code
 * end clock
 * 
 * 
 */
import java.util.Scanner;
public class matrix {
	public static void main (String [] args) {
		String again;
		Scanner input = new Scanner(System.in);
		do {
		long start, end, total;
		
		System.out.println("This program will multiply and add matrices");
		System.out.println("Enter a dimension (try 25+), so that a 2 square matrices will be built");
		System.out.println("with random generated entries ranging from 1 to 30");
		System.out.println();
		System.out.println("Enter the desired dimension of your square matricies(25+)");
		int dimension = input.nextInt();
		int [][] matrixA = new int[dimension][dimension]; 
		int [][] matrixB = new int[dimension][dimension];
		System.out.println("Matrix A");
		build(matrixA);
		System.out.println("Matrix B");
		build(matrixB);
		System.out.println();
		System.out.println("Matrix A + Matrix B");
		start = System.currentTimeMillis();
		add(matrixA,matrixB);
		end = System.currentTimeMillis();	total = end-start;//final-initial
		System.out.println("The addition of the 2 took " + total + " milliseconds");
		System.out.println();
		System.out.println("Matrix A * Matrix B");
		start = System.currentTimeMillis();
		multiply(matrixA,matrixB);
		end = System.currentTimeMillis(); total = end-start;
		System.out.println("The multiplication of the 2 took " + total + " milliseconds");	
		System.out.println("Would you like to repeat the program? (yes/no)");
		again =  input.next();
		}while("yes".equalsIgnoreCase(again));
	}	
	public static void build(int [][]matrix) {
		for(int x =0; x< matrix.length; x++) {//outer loop runs as dimension# of times
			for(int y=0;y< matrix[x].length; y++) {//same^^^
				Random num = new Random();
				matrix[x][y] = num.nextInt(30);
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println();
		}
	}
	
	public static void add(int[][] matrix1, int[][] matrix2) {
	//adds the matrices and displays them
	//adds corresponding entries together
	for(int x=0;x<matrix1.length; x++) {
		for(int y=0;y<matrix2.length;y++) {
			System.out.print(matrix1[x][y] +matrix2[x][y] + " ");
			}
		System.out.println();
		}	
	}
	public static void print(int [][]matrix) {
		for(int x =0; x< matrix.length; x++) {//outer loop runs as row# of times
			for(int y=0;y< matrix[x].length; y++) {
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println();
		}
	}
	public static void multiply(int[][] matrix1, int[][] matrix2) {
	//multiplies the matrices and displays them
	//creates a new array entirely, then prints it
		       int matrix1row = matrix1.length;
		       int matrix1column = matrix1[0].length;//same as rows in B
		       int matrix2column = matrix2[0].length;
		       int[][] matrix3 = new int[matrix1row][matrix2column];
		       for (int i = 0; i < matrix1row; i++) {//outer loop refers to row position
		           for (int j = 0; j < matrix2column; j++) {//refers to column position
		               for (int k = 0; k < matrix1column; k++) {
		            	   //adds the products of row*column elements until the row/column is complete
		            	   //updates to next row/column
		                   matrix3[i][j] = matrix3[i][j] + matrix1[i][k] * matrix2[k][j];
		               }
		           }
		       }
		   print(matrix3);
		  }
}


