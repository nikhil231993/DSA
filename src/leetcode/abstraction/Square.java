package leetcode.abstraction;

public class Square extends Shape {

	private int side;

	public Square(String color, int side) {
		super(color);
		this.side = side;
	}

	@Override
	int area() {
		return this.getSide() * this.getSide();
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

}
