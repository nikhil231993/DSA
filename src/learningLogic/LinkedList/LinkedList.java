package learningLogic.LinkedList;

public class LinkedList {

	private Node head;
	private int size;

	private class Node {
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void insertFirst(int value) {
		Node node = new Node(value);
		node.next = head;
		head = node;
		size++;

	}

	public void displayLinkedList() {
		System.out.println("Address of head:" + head);
		System.out.println("Address of head.next:" + head.next);
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("END");

	}

	public void addAtLast(int value) {
		Node node = new Node(value);
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
		size++;
	}

	public void addAtIndex(int index, int value) {
		if (index == 0) {
			insertFirst(value);
			return;
		}
		if (index == size) {
			addAtLast(value);
			return;
		}
		Node node = new Node(value);
		Node temp = head;
		
		for (int i = 0; i < index - 1; i++) {
			temp = temp.next;
		}
		node.next = temp.next;
		temp.next = node;
		size++;
		

	}

	public int findValue(int value) {
		Node temp = head;
		int loc = 0;
		while (temp.next != null) {
			if (temp.data == value) {
				return loc;
			} else {
				temp = temp.next;
				loc++;
			}
		}

		return -1;

	}

	public void deleteFirstNode() {
		if (head != null) {
			head = head.next;
			size--;
		}
		
	}

	public void deleteLastNode() {
		if (head == null)
			System.out.println("Empty linked list");
		else {
			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			temp.next = null;
			size--;
		}

	}

	public void deleteNodeBasedOnLocation(int index) {
		Node temp = head;

		if (index == 0) {
			deleteFirstNode();
			return;
		}
		if (index == size) {
			deleteLastNode();
			return;
		}
		if (index < size) {
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			size--;
		} else
			System.out.println("Index is greater than size of list");;

	}

}
