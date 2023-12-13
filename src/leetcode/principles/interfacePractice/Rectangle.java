package leetcode.principles.interfacePractice;

public interface Rectangle extends Shape {

	int length = 10;
	int breadth = 20;

	default void area() {
		System.out.println(length*breadth);
	}

	default void display() {
		System.out.println("Rectangle");
	}

}
