package DataStructures.list;

public class DoubleLinkedList {

	Node head;

	static class Node {
		int data;
		Node next;
		Node previous;

		Node(int d) {
			data = d;
		}
	}

	private void add(int i) {
		Node n = new Node(i);
		Node temp = head;
		if (head == null) {
			n.next = head;
			head = n;
			n.previous = null;
		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			n.previous = temp;
			temp.next = n;

		}

	}

	private void print() {
		if(head==null)
			System.out.println("list is null");
		else {

		Node temp = head;
		while (temp.next != null) {

			System.out.println(temp.data);
			temp = temp.next;

		}
		System.out.println(temp.data);
		}

	}

	private void addFirst(int i) {
		Node n = new Node(i);
		Node temp = head;
		n.previous = null;
		head = n;
		n.next = temp;

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

	private void deleteMiddleValue(int i) {
		//Node n = new Node(i);
		Node temp = head;
		while (temp.next != null) {
			if (temp.next.data != i) {
				temp = temp.next;
			} else {
				temp.next.next.previous = temp.next.next;
				temp.next = temp.next.next;
			}
		}

	}

	private void deleteLastValue() {
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;

	}

	private void deleteEntireList() {
		Node temp = head;
		while (temp.next != null) {

			temp.previous = null;
			temp = temp.next;

		}

		head = null;
		temp.next = null;

	}

	public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();
		System.out.println("--------------------------------------");
		System.out.println("adding first value in doible linked list");
		dll.add(10);
		dll.print();
		System.out.println("--------------------------------------");
		dll.add(20);
		dll.add(30);
		dll.add(40);
		dll.add(50);
		dll.add(60);
		dll.add(70);
		dll.add(80);
		dll.add(90);
		dll.add(100);
		System.out.println("adding other value in doible linked list");
		dll.print();
		System.out.println("--------------------------------------");
		System.out.println("adding at the starting value in doible linked list");
		dll.addFirst(5);
		dll.print();
		System.out.println("--------------------------------------");
		System.out.println("to add values in the middle");
		dll.addMiddle(55);
		dll.print();
		System.out.println("--------------------------------------");
		System.out.println("to delete values in the middle");
		dll.deleteMiddleValue(60);
		dll.print();
		System.out.println("--------------------------------------");
		System.out.println("to delete value  in the last");
		dll.deleteLastValue();
		dll.print();
		System.out.println("--------------------------------------");
		System.out.println("to delete a double linked list");
		dll.deleteEntireList();
		dll.print();
		System.out.println("--------------------------------------");

	}

}
