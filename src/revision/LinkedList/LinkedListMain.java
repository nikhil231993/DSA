package revision.LinkedList;

public class LinkedListMain {

	public static void main(String[] args) {
	
		LinkedList ll = new LinkedList();

		ll.insertFirst(10);
		ll.insertFirst(5);
		ll.insertFirst(6);
		ll.insertFirst(100);
		ll.insertFirst(1);
		System.out.println("LinkedList after adding element at first everytime:");
		ll.displayLinkedList();
		System.out.println();
		System.out.println("-----------------------------------------------------");
		ll.addAtLast(200);
		ll.addAtLast(300);
		ll.addAtLast(400);
		System.out.println("LinkedList after adding element at last everytime:");
		ll.displayLinkedList();
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("Adding node at a particular location in linkedlist:");
		ll.addAtIndex(5, 1000);
		ll.displayLinkedList();
		System.out.println();
		System.out.println("Adding node at a particular location i.e at first using location in linkedlist:");
		ll.addAtIndex(0, 10000);
		ll.displayLinkedList();
		System.out.println();
		System.out.println("Adding node at a particular location i.e at end using location in linkedlist:");
		ll.addAtIndex(10, 100000);
		ll.displayLinkedList();
		System.out.println();
		System.out.println("Finding a value in linkedlist:");
		int valueFoundAt = ll.findValue(200);
		System.out.println(valueFoundAt);
		System.out.println();
		System.out.println("Delete first node in linkedlist:");
		ll.deleteFirstNode();
		ll.displayLinkedList();
		System.out.println();
		System.out.println("Delete last node in linkedlist:");
		ll.deleteLastNode();
		ll.displayLinkedList();
		System.out.println();
		System.out.println("Delete at particular location of node in linkedlist:");
		ll.deleteNodeBasedOnLocation(4);
		ll.displayLinkedList();
		System.out.println();
		System.out.println("Delete at first location of node based on index in linkedlist:");
		ll.deleteNodeBasedOnLocation(1);
		ll.displayLinkedList();
		System.out.println();
		System.out.println("Delete at last location of node based on index in linkedlist:");
		ll.deleteNodeBasedOnLocation(7);
		ll.displayLinkedList();
		System.out.println();

	}

}
