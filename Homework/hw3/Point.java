package hw3;

public class Point {

	// private integer: x for vertical, y for horizontial
	private int x = 0;
	private int y = 0;

	// constructor
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	// set the point
	public void Set(int vertical, int horizontial) {
		x = vertical;
		y = horizontial;
	}
	// move the point
	public void Move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	// rotate the point 90 degree clockwise
	public void Rotate() {
		int temp = 0;
		temp = x;
		x = y;
		y = -temp;
	}
	// get x
	public int RetreiveVertical() {
		return x;
	}
	// get y
	public int RetreiveHorizontial() {
		return y;
	}
	// Manhattan distance
	public int calculateManhattanDistance(Point other) {
		// d = |x1-x2| + |y1-y2|
		int distance = Math.abs(other.x - x) + Math.abs(other.y - y);
		return distance;
	}
	// ChebyshevDistance
	public double ChebyshevDistance(Point other) {
		// d = max(|x1-x2|, |y1-y2|)
		int distance = Math.max(Math.abs(other.x - x), Math.abs(other.y - y));
		return distance;
	}
}