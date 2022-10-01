package revision.LinkedList;

public class DoublyLinkedList {

	Node head;
	int size;

	private class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	public void addFirst(int data) {
		Node node = new Node(data);
		if (head == null) {
			node.next = head;
		} else {
			head.prev = node;
			node.next = head;
		}
		head = node;
		size++;
		}

	public void display() {
		Node temp = head;
		while (temp.next != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data + "-->");

	}

	public void reverseDsiplay() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		while (temp != head) {
			System.out.print(temp.data + "-->");
			temp = temp.prev;
		}
		System.out.println(temp.data + "-->");

	}

	public void addLast(int data) {
		Node node = new Node(data);
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		node.prev = temp;
		temp.next = node;
		size++;

	}

	public void addAtParticularPos(int pos, int data) {

		if (pos == 1) {
			addFirst(data);
			return;
		} else if (pos == size + 1) {
			addLast(data);
			return;
		} else {
			Node node = new Node(data);
			Node temp=head;
			for (int i = 1; i < pos - 1; i++) {
				temp = temp.next;
			}
			temp.next.prev = node;
			node.next = temp.next;
			node.prev = temp;
			temp.next = node;
			size++;
		}

	}

	public void deleteFirst() {
		head.next.prev = null;
		head = head.next;
		size--;

	}

	public void deleteAtLast() {
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next.prev = null;
		temp.next = null;
		size--;

	}

	public void deletAtIndex(int index) {
		if (index == 1) {
			deleteFirst();
			return;
		} else if (index == size) {
			deleteAtLast();
			return;
		}else {
			Node temp=head;
			for(int i=1;i<index-1;i++) {
				temp = temp.next;
			}

			temp.next.next.prev = temp;
			temp.next = temp.next.next;
			size--;
		}

	}
}
