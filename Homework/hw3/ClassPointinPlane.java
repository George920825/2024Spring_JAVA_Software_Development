package hw3;
import java.util.Scanner;

public class ClassPointinPlane {

	public static void main(String[] args) {
		// scanner keyboard
		Scanner keyboard = new Scanner(System.in);
		// get main point
		int main_x = keyboard.nextInt();
		int main_y = keyboard.nextInt();
		Point mainPoint = new Point(main_x, main_y);
		System.out.println(mainPoint.RetreiveVertical() + " " + mainPoint.RetreiveHorizontial());
		// get other point
		int other_x = keyboard.nextInt();
		int other_y = keyboard.nextInt();
		Point otherPoint = new Point(other_x, other_y);
		// get move value
		int move_x = keyboard.nextInt();
		int move_y = keyboard.nextInt();
		keyboard.close();
		// move main point
		mainPoint.Move(move_x, move_y);
		System.out.println(mainPoint.RetreiveVertical() + " " + mainPoint.RetreiveHorizontial());
		// rotate 1
		mainPoint.Rotate();
		System.out.println(mainPoint.RetreiveVertical() + " " + mainPoint.RetreiveHorizontial());
		// rotate 2
		mainPoint.Rotate();
		System.out.println(mainPoint.RetreiveVertical() + " " + mainPoint.RetreiveHorizontial());
		// rotate 3
		mainPoint.Rotate();
		System.out.println(mainPoint.RetreiveVertical() + " " + mainPoint.RetreiveHorizontial());
		// rotate 4
		mainPoint.Rotate();
		System.out.println(mainPoint.RetreiveVertical() + " " + mainPoint.RetreiveHorizontial());
		// Manhattan Distance
		System.out.println(mainPoint.calculateManhattanDistance(otherPoint));
		// Chebyshev Distance
		System.out.println(mainPoint.ChebyshevDistance(otherPoint));
	}
}