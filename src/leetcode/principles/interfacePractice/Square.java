package leetcode.principles.interfacePractice;

public interface Square extends Shape {
	
	int side=10;
	
	default void area() {
		System.out.println(side*side);
	}
	
	default void display() {
		System.out.println("Square");
	}

}
