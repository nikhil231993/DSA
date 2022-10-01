package revision.LinkedList;

public class CircularDoublyLinkedListMain {

	public static void main(String[] args) {
		
		//testA
		CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
		cdll.addFirst(1);
		System.out.println("Display after adding 1st element at first:");
		cdll.display();
		cdll.addFirst(11);
		System.out.println("Display after adding 2nd element at first:");
		cdll.display();
		cdll.addFirst(111);
		System.out.println("Display after adding 3rd element at first:");
		cdll.display();
		System.out.println("Display after adding element at last:");
		cdll.addAtLast(200);
		cdll.display();
		System.out.println("At a particular location in Linked list i.e 2nd");
		cdll.addAtPosition(2, 50);
		cdll.display();
		cdll.reverseDisplayFromHead();
		System.out.println("At a particular location in Linked list i.e 1st");
		cdll.addAtPosition(1, 1111);
		cdll.display();
		System.out.println("At a particular location in Linked list i.e last");
		cdll.addAtPosition(6, 300);
		cdll.display();
		System.out.println("Search 50 in Circular Doubly Linked List:");
		int pos = cdll.searchValue(50);
		System.out.println("Value 50 found at " + pos);
		System.out.println("Circular Linked List Validation:");
		cdll.reverseDisplayFromHead();
		System.out.println("Deleting First Element in the Linked List:");
		cdll.display();
		cdll.deleteAtFirst();
		cdll.display();
		System.out.println("Deleting Last Element in the Linked List:");
		cdll.deleteAtLast();
		cdll.display();
		System.out.println("Deleting at particular position in the Linked List: 2nd");
		cdll.deleteAtLoc(2);
		cdll.display();
		System.out.println("Deleting at particular position in the Linked List: 1st");
		cdll.deleteAtLoc(1);
		cdll.display();
		System.out.println("Deleting at particular position in the Linked List: last");
		cdll.deleteAtLoc(3);
		cdll.display();
	
	}

}
