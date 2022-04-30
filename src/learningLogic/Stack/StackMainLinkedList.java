package learningLogic.Stack;

public class StackMainLinkedList {

	public static void main(String[] args) {

		StackCustomUsingLinkedList stack = new StackCustomUsingLinkedList();
		stack.push(10);
		stack.push(20);
		stack.push(30);
 
        System.out.println(stack.pop()
                           + " popped from stack");
 
        System.out.println("Top element is " + stack.peek());

	}

}
