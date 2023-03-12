package DataStructures.Stack;

public class StackUsingLinkedList {

	Stack root;

	static class Stack {
		int data;
		Stack next;

		Stack(int d) {
			data = d;
			next = null;
		}
	}

	private void isEmpty() {
		if(root==null)
			System.out.println("empty");

	}

	private void isFull() {
		// TODO Auto-generated method stub

	}

	private void pop() {
		if(root==null)
			System.out.println("underflow");
		else
		{
		root=root.next;		
		
		}

	}

	private void peek() {
		if(root==null)
			System.out.println("underflow");
		else
		System.out.println(root.data);

	}

	private void push(int i) {
		Stack stack = new Stack(i);
		if (root == null) {

			root = stack;
		} else {
			stack.next = root;
			root = stack;

		}

	}

	public static void main(String[] args) {
		StackUsingLinkedList s = new StackUsingLinkedList();
		System.out.println("Pushing elemts into stack using linked list");
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
		System.out.println("Peek of element at the top of stack using linked list");
		s.peek();
		System.out.println("------------------------------------------");
		System.out.println("pop of top elemt from the queue using linked list");
		s.pop();
		s.peek();
		System.out.println("------------------------------------------");
		System.out.println("to check if isempty using linked list");
		s.isEmpty();
		System.out.println("------------------------------------------");

	}

}
