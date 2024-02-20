package leetcode.stack.striver;

public class StackUsingLinkedList {

	private Node head;

	private class Node {

		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void push(int data) {

		Node node = new Node(data);
		node.next = head;
		head = node;
		System.out.println(head.data + " pushed to stack");
	}

	public int pop() {

		if(head==null) {
			System.out.println("Stack is empty ");
			return -1;
		}
		int value=head.data;
		head = head.next;
		return value;
	}

	public int peek() {

		if (head == null) {
			System.out.println("Stack is empty ");
			return -1;
		}
		return head.data;
	}
}
