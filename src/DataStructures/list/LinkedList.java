package DataStructures.list;
import java.util.Scanner;

// creating a linked list node
class Node {
	int d;
	Node next;

	Node(int data) {
		this.d = data;
		this.next = null;
	}

}

public class LinkedList {

	Node head;

	public void add(int data) {
		Node n = new Node(data);
		if (head == null)
			head = n;
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}

	}

	public void traverse() {
		Node temp = head;
		while (temp.next != null) {
			System.out.println(temp.d);
			temp = temp.next;
		}
		System.out.println(temp.d);

	}

	public void addFirst(int i) {
		Node n = new Node(i);
		Node temp = head;
		head = n;
		n.next = temp;

	}

	public void addLast(int i) {
		Node n = new Node(i);
		Node temp = head;
		while (temp.next != null)
			temp = temp.next;
		temp.next = n;
	}

	public int searchValue(int i) {
		int pos = 0;
		Node temp = head;
		if (temp.next != null || temp.d != i) {
			while (temp.d != i) {
				temp = temp.next;
				pos++;
			}

		} else
			pos = pos + 1;
		return pos;
	}

	public void deleteValue(int i) {
		// Node n=new Node(i);
		Node temp = head;

		while (temp.next.next != null) {
			if (temp.next.d != i)
				temp = temp.next;
			else
				temp.next = temp.next.next;
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		System.out.println("Enter the elemts to be inserted into linked list: ");
		int size = scan.nextInt();
		for (int i = 0; i < size; i++) {
			ll.add(i);
		}
		ll.traverse();
		// adding node at first
		ll.addFirst(-1);
		System.out.println("-----------------------------------------------------------");
		System.out.println("after adding -1 at the top");
		ll.traverse();
		// adding node at last
		System.out.println("-----------------------------------------------------------");
		ll.addLast(100);
		System.out.println("afte adding 100 at last");
		ll.traverse();
		System.out.println("-----------------------------------------------------------");
		System.out.println("Search for a particular value: ");
		int locValue = ll.searchValue(3);
		System.out.println(locValue);
		System.out.println("-----------------------------------------------------------");
		System.out.println("Deleting a value from the linked list");
		ll.deleteValue(100);
		ll.traverse();
		System.out.println("-----------------------------------------------------------");
		scan.close();
	}

}
