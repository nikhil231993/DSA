package revision.LinkedList;

public class CircularLinkedList {

	Node head;
	int size;

	private class Node {

		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void addFirst(int data) {
		Node node = new Node(data);
		if (head == null) {
			node.next = head;
			head = node;
			head.next = node;
			size++;
		} else {
			node.next = head;
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = node;
			head = node;
			size++;
		}

	}

	public void display() {
		Node temp = head;
		while (temp.next != head) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data + "-->");

	}

	public void addAtLast(int data) {
		Node node = new Node(data);
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp.next = node;
		node.next = head;
		size++;
	}

	public void addAtPosition(int pos, int data) {
		Node node = new Node(data);
		Node temp = head;

		if (pos < 0 || pos > size + 1) {
			System.out.println("Invalid Location to insert");
			return;
		}
		if (pos == 1) {
			addFirst(data);
			return;
		} else if (pos == size + 1) {
			addAtLast(data);
			return;
		} else {
			for (int i = 1; i < pos - 1; i++) {
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
			size++;
		}

	}

	public void deleteAtFirst() {
		if (head != null) {
			Node temp = head;

			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			head = head.next;
			size--;
		} else {
			System.out.println("Circular linked list is empty: ");
		}
	}

	public void deleteAtLast() {
		if (head != null) {
			Node temp = head;
			while (temp.next.next != head) {
				temp = temp.next;
			}
			temp.next = head;
			size--;
		} else {
			System.out.println("Circular linked list is empty: ");
		}

	}

	public void deleteAtPos(int pos) {
		Node temp = head;
		if (pos == 1) {
			deleteAtFirst();
			return;
		} else if (pos == size) {
			deleteAtLast();
			return;
		} else {
			for (int i = 1; i < pos - 1; i++) {
				temp = temp.next;
			}
			temp.next = temp.next.next;
			size--;

		}
	}

}
