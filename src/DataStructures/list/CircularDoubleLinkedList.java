package DataStructures.list;

public class CircularDoubleLinkedList {

	Node head;

	class Node {
		int data;
		Node next;
		Node previous;

		Node(int d) {
			data = d;
			next = null;
			previous = null;
		}
	}

	private void add(int i) {
		Node n = new Node(i);
		Node temp = head;
		if (head == null) {

			head = n;
			n.previous = head;
			n.next = head;
		} else {
			while (temp.next != head) {
				temp = temp.next;
			}
			n.previous = temp;
			temp.next = n;
			n.next = head;

		}

	}

	private void addFirst(int i) {
		Node n = new Node(i);
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		n.previous = temp;
		n.next = head;
		head = n;
		temp.next = n;

	}

	private void print() {
		Node temp = head;
		while (temp.next != head) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

	private void addMiddle(int i) {
		Node n = new Node(i);
		Node temp = head;
		while (temp.next.next.data < i) {
			temp = temp.next;
		}
		n.previous = temp.next;
		n.next = temp.next.next;
		temp.next.next = n;
		temp.next.previous = n;
	}

	private void deleteMiddle(int i) {
		Node temp = head;
		while (temp.next != head) {
			if (temp.next.data != i) {
				temp = temp.next;
			} else {
				temp.next = temp.next.next;
				temp.next.next.previous = temp;
			}

		}

	}

	private void deleteFirst() {
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		temp = temp.next.previous;
		temp.next = temp.next.next;
		head = temp.next;

	}

	private void deleteLast() {
		Node temp = head;
		while (temp.next.next != head) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		temp.next.next.previous = temp.next;
	}

	private void deleteEntireList() {
		Node temp = head;
		while (temp.next != head) {
			temp.previous = null;
			temp = temp.next;
		}
		temp.next = null;
		head = null;

	}

	public static void main(String[] arg) {
		CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
		System.out.println("to add first elemt in circular double linked list");
		cdll.add(10);
		cdll.print();
		System.out.println("-----------------------------------------------------");
		System.out.println("after adding other elements in the circular double linked list");
		cdll.add(20);
		cdll.add(30);
		cdll.add(40);
		cdll.add(50);
		cdll.add(60);
		cdll.add(70);
		cdll.add(80);
		cdll.add(90);
		cdll.add(100);
		cdll.print();
		System.out.println("-----------------------------------------------------");
		System.out.println("to add value at first");
		cdll.addFirst(5);
		cdll.print();
		System.out.println("-----------------------------------------------------");
		System.out.println("to add value in middle in linked list");
		cdll.addMiddle(55);
		cdll.print();
		System.out.println("-----------------------------------------------------");
		System.out.println("to delete a value from the middle");
		cdll.deleteMiddle(40);
		cdll.print();
		System.out.println("-----------------------------------------------------");
		System.out.println("to delete a value from the first");
		cdll.deleteFirst();
		cdll.print();
		System.out.println("-----------------------------------------------------");
		System.out.println("to delete a value from the list");
		cdll.deleteLast();
		cdll.print();
		System.out.println("-----------------------------------------------------");
		System.out.println("to delete linked list");
		cdll.deleteEntireList();
		System.out.println("-----------------------------------------------------");
	}

}
