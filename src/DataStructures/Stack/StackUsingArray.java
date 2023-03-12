package DataStructures.Stack;

public class StackUsingArray {

	int top;
	int max = 100;
	int[] arr = new int[max];

	StackUsingArray() {
		top = -1;
	}

	private void peek() {
		if (top == -1)
			System.out.println("Underflow");
		else
			System.out.println(arr[top]);

	}

	private void push(int i) {
		top++;
		System.out.println("Value added is: " + i);
		arr[top] = i;

	}

	private void pop() {
		if (top == -1)
			System.out.println("Underflow");
		else {
			top--;
		}

	}

	private void isEmpty() {
	if(top==-1)
		System.out.println("stack is emplty");

	}

	private void isFull() {
		if(top==max)
			System.out.println("is full");

	}

	public static void main(String[] args) {
		StackUsingArray s = new StackUsingArray();
		System.out.println("Pushing elemts into stack");
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.push(70);
		s.push(80);
		s.push(90);
		System.out.println("------------------------------------------");
		System.out.println("Peek of element at the top of stack");
		s.peek();
		System.out.println("------------------------------------------");
		System.out.println("pop of top elemt from the queue");
		s.pop();
		s.peek();
		System.out.println("------------------------------------------");
		System.out.println("to check if is full");
		s.isFull();
		System.out.println("------------------------------------------");
		System.out.println("to check if isempty");
		s.isEmpty();
		System.out.println("------------------------------------------");

	}

}
