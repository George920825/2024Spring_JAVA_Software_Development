package hw6;

import java.util.Scanner;

public class Tic_tac_toe {
	public static void main(String[] args) {
		 // scanner keyboard
		Scanner keyboard = new Scanner(System.in);
		String boardState = keyboard.nextLine();
		keyboard.close();

		 // check if boardstate is valid or not and output
		System.out.println(BoardStateValidation(boardState));
	}
	
	private static String BoardStateValidation(String boardState) {
		 // count number of "X" and "O"
		int XNum = 0;
		int ONum = 0;
		for (int i = 0; i < boardState.length(); i++) {
			if (boardState.charAt(i) == 'X') {
				XNum++;
			}
			else if (boardState.charAt(i) == 'O') {
				ONum++;
			}
		}
		 // check number of "X" and "O"
		if (XNum == ONum || XNum == ONum+1) {
			 // check XWin or OWin ...
			boolean XWin = CheckWin(boardState, 'X');
			boolean OWin = CheckWin(boardState, 'O');
			
			 // both win
			if (XWin && OWin) {
				return "invalid";
			}
			 // X win but # is not correct
			else if (XWin && XNum != ONum+1) {
				return "invalid";
			}
			 // O win but # is not correct
			else if (OWin && XNum != ONum) {
				return "invalid";
			}
			else {
				return "valid";
			}
		}
		 // # is not correct
		else {
			return "invalid";
		}
	}
	
	private static boolean CheckWin(String boardState, char letter) {
		for (int i = 0; i < 3; i++) {
			 // check row elements are letter
			if (letter == boardState.charAt(i*3) && boardState.charAt(i*3) == boardState.charAt(i*3 + 1)
			 	&& boardState.charAt(i*3 + 1) == boardState.charAt(i*3 + 2)) {
				return true;
			}
			 // check column elements are letter
			else if (letter == boardState.charAt(i) && boardState.charAt(i) == boardState.charAt(i+3)
			 		 && boardState.charAt(i+3) == boardState.charAt(i+6)) {
				return true;
			}
		}
		 // check diagonal elements are letter
		if ((letter == boardState.charAt(0) && boardState.charAt(0) == boardState.charAt(4)
			&& boardState.charAt(4) == boardState.charAt(8)) || (letter == boardState.charAt(2)
			 && boardState.charAt(2) == boardState.charAt(4) && boardState.charAt(4) == boardState.charAt(6))) {
			return true;
		}
		return false;
	}
}
