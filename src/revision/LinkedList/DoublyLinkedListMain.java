package revision.LinkedList;

public class DoublyLinkedListMain {

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.addFirst(5);

		System.out.println("Display after adding the node at First:");
		dll.display();
//		dll.deleteFirst();
//		dll.display();
//		dll.reverseDisplay();
		dll.addFirst(50);
		dll.addFirst(500);
		dll.addFirst(5000);
		System.out.println("Display after adding the node at First:");
		dll.display();
		System.out.println("Display in reverse after adding the node at First:");
		dll.reverseDisplay();
		dll.addLast(1);
		System.out.println("Display after adding the node at Last:");
		dll.display();
		dll.addAtParticularPos(3, 39);
		System.out.println("Display after adding the node at particular position:");
		dll.display();
		System.out.println("Display after adding the node at particular position in reverse:");
		dll.reverseDisplay();
		dll.addAtParticularPos(6, 390);
		System.out.println("Display after adding the node at last position:");
		dll.display();
		System.out.println("Display after adding the node at last position in reverse:");
		dll.reverseDisplay();
		dll.deleteFirst();
		System.out.println("Display after deleting the node at first position:");
		dll.display();
		System.out.println("Display after deleting the node at first position in reverse:");
		dll.reverseDisplay();
		dll.deleteAtLast();
		System.out.println("Display after deleting the node at Last position:");
		dll.display();
		System.out.println("Display after deleting the node at Last position in reverse:");
		dll.reverseDisplay();
		dll.deletAtIndex(3);
		System.out.println("Display after deleting the node at particular position:");
		dll.display();
		System.out.println("Display after deleting the node at particular position in reverse:");
		dll.reverseDisplay();
		dll.deletAtIndex(1);
		System.out.println("Display after deleting the node at 1st position:");
		dll.display();
		System.out.println("Display after deleting the node at 1st position in reverse:");
		dll.reverseDisplay();
		dll.deletAtIndex(3);
		System.out.println("Display after deleting the node at Last position:");
		dll.display();
		System.out.println("Display after deleting the node at Last position in reverse:");
		dll.reverseDisplay();
		System.out.println("Deletion of entire DLL");
		dll.deletEntireLinkedList();
		dll.display();
		dll.reverseDisplay();

	}

}
