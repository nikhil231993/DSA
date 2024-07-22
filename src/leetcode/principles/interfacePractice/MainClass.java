package leetcode.principles.interfacePractice;

public class MainClass implements Rectangle, Square {

	public static void main(String[] args) {

		MainClass mC = new MainClass();
		mC.area();
		mC.display();

		System.out.println(side);
		System.out.println(length);
		System.out.println(breadth);
	}

	@Override
	public void area() {
		Rectangle.super.area();
		Square.super.area();
	}

	@Override
	public void display() {
		Rectangle.super.display();
		Square.super.display();
	}
}
