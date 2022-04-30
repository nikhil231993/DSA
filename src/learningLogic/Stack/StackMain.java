package learningLogic.Stack;

public class StackMain {

	public static void main(String[] args) {

		StackCustomUsingArray stack = new StackDynamic(1);
		stack.push(1);
		stack.push(10);
		stack.push(100);
		stack.push(1000);
		stack.push(10000);
		stack.push(8);

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println("Peek: ");
		System.out.println(stack.peek());
		System.out.println(stack.isFull());
		System.out.println(stack.isEmpty());

	}

}
