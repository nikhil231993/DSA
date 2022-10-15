package revision.LinkedList;

public class CircularLinkedListMain {

	public static void main(String[] args) {
		CircularLinkedList cll=new CircularLinkedList();
		
		cll.addFirst(1);
		System.out.println("Display after adding 1st element at first:");
		cll.display();
//		cll.deleteAtFirst();
//		cll.display();
		cll.addFirst(11);
		System.out.println("Display after adding 2nd element at first:");
		cll.display();
		cll.addFirst(111);
		System.out.println("Display after adding 3rd element at first:");
		cll.display();
		System.out.println("Display after adding element at last:");
		cll.addAtLast(200);
		cll.display();
		System.out.println("At a particular location in Linked list i.e 2nd");
		cll.addAtPosition(2, 50);
		cll.display();
		System.out.println("At a particular location in Linked list i.e 1st");
		cll.addAtPosition(1, 1111);
		cll.display();
		System.out.println("At a particular location in Linked list i.e last");
		cll.addAtPosition(6, 300);
		cll.display();
		System.out.println("Deleting First Element in the Linked List:s");
		cll.deleteAtFirst();
		cll.display();
		System.out.println("Deleting Last Element in the Linked List:s");
		cll.deleteAtLast();
		cll.display();
		System.out.println("Deleting at particular position in the Linked List: 2nd");
		cll.deleteAtPos(2);
		cll.display();
		System.out.println("Deleting at particular position in the Linked List: 1st");
		cll.deleteAtPos(1);
		cll.display();
		System.out.println("Deleting at particular position in the Linked List: last");
		cll.deleteAtPos(3);
		cll.display();
	}

}
