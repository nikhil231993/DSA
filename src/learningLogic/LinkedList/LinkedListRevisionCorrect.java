package learningLogic.LinkedList;

public class LinkedListRevisionCorrect {
	private Node head;
	private int size = 0;

	private class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public void insertFirst(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		size++;

	}

	public void displayLinkedList() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.value + "->");
			temp = temp.next;
		}
		System.out.println("END");

	}

	public void addAtLast(int data) {

		Node node = new Node(data);
		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		size++;

	}

	public void addAtIndex(int pos, int data) {
		Node node = new Node(data);
		Node temp = head;

		if (pos == 0) {
			insertFirst(data);
			return;
		}

		if (pos == size) {
			addAtLast(data);
			return;
		}
		for (int i = 0; i < pos - 1; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		size++;

	}

	public int findValue(int data) {

		Node temp = head;
		int loc = 1;
		while (temp != null) {
			if (temp.value == data) {
				return loc;
			}
			temp = temp.next;
			loc++;
		}
		return -1;
	}

	public void deleteFirstNode() {

		if (head != null) {
			head = head.next;
			size--;
			System.out.println("Current size is:" + size);
		} else {
			System.out.println("Linked List is empty");
		}

	}

	public void deleteLastNode() {
		if (head != null) {
			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}

			temp.next = null;
			size--;
		} else {
			System.out.println("Linked List is empty");
		}

	}

	public void deleteNodeBasedOnLocation(int pos) {

		Node temp = head;
		if (pos == 1) {
			deleteFirstNode();
			return;
		}
		if (pos == size) {
			deleteLastNode();
			return;
		}

		for (int i = 1; i < pos - 1; i++) {
			temp = temp.next;
		}

		temp.next = temp.next.next;
		size--;

	}
}
