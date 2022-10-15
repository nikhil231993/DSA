package revision.stack;

public class StackUsingLinkedListMain {

	public static void main(String[] args) {

		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(10);
		stack.push(20);
		stack.push(30);
 
        System.out.println(stack.pop()
                           + " popped from stack");
 
        System.out.println("Top element is " + stack.peek());

	}

}
