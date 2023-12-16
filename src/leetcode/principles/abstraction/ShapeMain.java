package leetcode.principles.abstraction;

public class ShapeMain {

	public static void main(String[] args) {
		Shape shape1 = new Rectangle("Yellow", 5, 10);
		Shape shape2 = new Square("white", 6);
		System.out.println(shape1.area());
		System.out.println(shape2.area());

	}

}
