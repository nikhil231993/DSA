package leetcode.principles.abstraction;

public abstract class Shape {

	private String color;

	private int length;

	private int breadth;

	public Shape(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public void display() {
		System.out.println("Color is : " + color);
	}

	abstract int area();
}
