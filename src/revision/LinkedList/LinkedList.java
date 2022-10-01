package revision.LinkedList;

public class LinkedList {

	Node head;
	int size;

	private class Node {

		int data;
		Node next;

		Node(int data) {
			this.data = data;

		}
	}

	public void insertFirst(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
		size++;

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

	public void displayLinkedList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
	}

	public void addAtIndex(int index, int data) {

		Node node = new Node(data);
		Node temp = head;
		if (index < 0 || index > size) {
			System.out.println("Index is out of bound: ");
			return;
		}

		if (index == 0)
			insertFirst(data);
		else {
			for (int i = 1; i < index - 1; i++) {
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
			size++;
		}

	}

	public int findValue(int data) {
		int pos = 0;
		Node temp = head;
		while (temp != null) {
			if (temp.data == data) {
				return pos + 1;
			}
			temp = temp.next;
			pos++;
		}
		return -1;

	}

	public void deleteFirstNode() {
		head = head.next;
		size--;
	}

	public void deleteLastNode() {
		Node temp = head;

		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		size--;
	}

	public void deleteNodeBasedOnLocation(int index) {
		if (index == 1) {
			deleteFirstNode();
			return;
		}
		Node temp = head;
		for (int i = 1; i < index - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		size--;

	}

}
