package hw5;

import java.util.Scanner;

public class WordInBoard {
	public static void main(String[] args) {

		 // scanner keyboard
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt(); // # row
		int m = keyboard.nextInt(); // # column
		String junk = keyboard.nextLine();
		 // input board
		char[][] board = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = Character.toUpperCase(keyboard.next().charAt(0));
			}
			junk = keyboard.nextLine();
		}
		//  // print board to debug
		// print_board(board);
		 // input target
		String target = keyboard.nextLine().toUpperCase();
		//  // print target to debug
		// System.out.println(target);
		 // output
		System.out.println(find(board, target, n, m));
		keyboard.close();
	}

	private static boolean find(char[][] board, String target, int n, int m) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				 // check if it is the first character of the target
				if (board[i][j] == target.charAt(0)) {

					 // search the target from board[i][j] (start point)
					if (search(board, i, j, target, 0, n, m)) {
						return true;
					}
				} 
			}
		}

		 // gone through broad but did not find target
		return false;
	}

	private static boolean search(char[][] board, int row, int column, String target, int target_index, int n, int m) {

		 // all the characters of target are found
		if (target_index == target.length()) {
			return true;
		}
		 // check if out of board
		if (row < 0 || row > n-1 || column < 0 || column > m-1) {
			return false;
		}
		 // check if character of board[row][column] and target[target_index] are same
		if (board[row][column] != target.charAt(target_index)) {
			return false;
		}

		 // mask the used character in board
		char temp = board[row][column];
		board[row][column] = '*';
		
		//  // print board to debug
		// print_board(board);

		 // search adjacent elements by recursion
		boolean found = search(board, row+1, column, target, target_index+1, n, m) ||
						search(board, row, column+1, target, target_index+1, n, m) ||
						search(board, row-1, column, target, target_index+1, n, m) ||
						search(board, row, column-1, target, target_index+1, n, m);
		
		 // recovery the board
		board[row][column] = temp;

		return found;
	}

	//  // print board to debug
	// private static void print_board(char[][] board) {
	// 	int n = board.length; // row
	// 	int m = board[0].length; // column
	// 	for (int i = 0; i < n; i++) {
	// 		for (int j = 0; j < m; j++) {
	// 			System.out.print(board[i][j]);
	// 		}
	// 		System.out.println("");
	// 	}
	// 	System.out.println("");
	// }
}