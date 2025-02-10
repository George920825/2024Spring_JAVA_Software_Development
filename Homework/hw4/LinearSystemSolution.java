package hw4;

import java.util.Scanner;

public class LinearSystemSolution {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		// get row & column
		int row = keyboard.nextInt();
		String junk = keyboard.nextLine();
		if (row <= 0 || row >= 10) {
			System.out.println("input invalid n");
			keyboard.close();
			System.exit(0);
		}
		int column = row + 1;
		// get input equations
		double[][] linearSystem = new double[row][column];
		for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
				double inputValue = keyboard.nextInt();
				if (j == column - 1) {
					if (inputValue < -250 || inputValue > 250) {
						System.out.println("input invalid bi");
						keyboard.close();
						System.exit(0);
					}
				}
				else {
					if (inputValue < -100 || inputValue > 100) {
						System.out.println("input invalid ai");
						keyboard.close();
						System.exit(0);
					}
				}
                linearSystem[i][j] = inputValue;
            }
			junk = keyboard.nextLine();
        }
		int endValue = keyboard.nextInt();
		junk = keyboard.nextLine();
		if (endValue != -999) {
			System.out.println("input invalid end");
			keyboard.close();
			System.exit(0);
		}
		keyboard.close();
		// Gaussian elimination
		int eliminationControl = 1; // 1 for next row, 0 for repeat this row again
		for (int i = 0, j = 0; i < row-1; i++, j++) { // go row by row
			if (linearSystem[i][j] == 0) { // check the element to divide is zero or not
				if (j == column-1) { // [0, 0, 0, ... , 0 | 0]
					System.out.println("Infinite solutions");
					System.exit(0);
				}
				for (int k = i+1; k < row; k++) { // find the row below to swap, row by row
					if (linearSystem[k][j] != 0) { // if the other row below is not zero
						eliminationControl = 1;
						// swap them
						double[] temp = linearSystem[i];
						linearSystem[i] = linearSystem[k];
						linearSystem[k] = temp;
						break; // if success then stop the find process
					}
					if (k == row-1) {
						eliminationControl = 0; // skip elimination
						i--; // do this row again but leading one will be the next column
					}
				}
			}
			else {
				eliminationControl = 1;
				if (j == column-1) { // [0, 0, 0, ... , 0 | n]
					System.out.println("No solution");
					System.exit(0);
				}
			}
			// print to debug
			// for (int m = 0; m < row; m++) {
			// 	for (int n = 0; n < column; n++) {
			// 		System.out.print(linearSystem[m][n] + " ");
			// 	}
			// 	System.out.println();
			// }
			if (eliminationControl == 1) {
				// double leadingNum = linearSystem[i][j];
				// for (int k = j; k < column; k++) {
				// 	linearSystem[i][k] /= leadingNum;
				// }
				for (int k = i+1; k < row; k++) { // do the Gaussian elimination to the row below
					double multiplicand = linearSystem[k][j] / linearSystem[i][j];
					for (int l = j; l < column; l++) {
						linearSystem[k][l] -= multiplicand * linearSystem[i][l];
						// print to debug
						// for (int m = 0; m < row; m++) {
						// 	for (int n = 0; n < column; n++) {
						// 		System.out.print(linearSystem[m][n] + " ");
						// 	}
						// 	System.out.println();
						// }
					}
				}
			}
			
		}
		// count # of zeros in the last equation
		int zero = 0;
		for (int i = 0; i < column; i++) {
			zero = (linearSystem[row-1][i] == 0) ? zero+1 : zero;
		}
		// output by checking # of zeros in the last equation
		if (zero == column) {
			System.out.println("Infinite solutions");
		}
		else if (zero == column-1 && linearSystem[row-1][column-1] != 0) {
			System.out.println("No solution");
		}
		else {
			System.out.println("The only solution");
		}

		// // Gaussian elimination
		// for (int i = 0; i < row-1; i++) { // go row by row
		// 	if (linearSystem[i][i] == 0) { // check the element to divide is zero or not
		// 		for (int j = 0; j < row-i-1; j++) { // find the row below to swap, row by row
		// 			if (linearSystem[i+j+1][i] != 0) { // if the other row below is not zero
		// 				// swap them
		// 				int[] temp = linearSystem[i];
		// 				linearSystem[i] = linearSystem[i+j+1];
		// 				linearSystem[i+j+1] = temp;
		// 				break; // if success then stop the find process
		// 			}
		// 		}
		// 	}
		// 	// print to debug
		// 	for (int j = 0; j < row; j++) {
		// 		for (int k = 0; k < column; k++) {
		// 			System.out.print(linearSystem[j][k] + " ");
		// 		}
		// 		System.out.println();
		// 	}
		// 	for (int j = 0; j < row-i-1; j++) { // do the Gaussian elimination to the row below
		// 		double multiplicand = linearSystem[i+j+1][i] / linearSystem[i][i];
		// 		for (int k = 0; k < column; k++) {
		// 			linearSystem[i+j+1][k] -= multiplicand * linearSystem[i][k];
		// 			// print to debug
		// 			for (int m = 0; m < row; m++) {
		// 				for (int n = 0; n < column; n++) {
		// 					System.out.print(linearSystem[m][n] + " ");
		// 				}
		// 				System.out.println();
		// 			}
		// 		}
		// 	}
		// }
		// // count # of zeros in the last equation
		// int zero = 0;
		// for (int i = 0; i < column; i++) {
		// 	zero = (linearSystem[row-1][i] == 0) ? zero+1 : zero;
		// }
		// // output by checking # of zeros in the last equation
		// if (zero == column) {
		// 	System.out.println("Infinite solutions");
		// }
		// else if (zero == column-1 && linearSystem[row-1][column-1] != 0) {
		// 	System.out.println("No solution");
		// }
		// else {
		// 	System.out.println("The only solution");
		// }
	}
}
