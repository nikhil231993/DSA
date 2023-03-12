package DataStructures.list;

public class CircularLinkedList {

	Node head;

	class Node {
		int d;
		Node next;

		Node(int data) {
			this.d = data;
			this.next = null;
		}
	}

	private void add(int i) {
		Node n = new Node(i);
		if (head == null) {
			n.next = head;
			head = n;
			n.next = head;
		} else {
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = n;
			n.next = head;

		}
	}

	private void print() {
		if(head==null) {
			System.out.println("list is null");
		}
		else
		{
		Node temp = head;
		while (temp.next != head) {
			System.out.println(temp.d);
			temp = temp.next;
		}
		System.out.println(temp.d);
		}
	}

	private void deletevalue(int i) {
		//Node n = new Node(i);
		Node temp = head;

		while (temp.next != head) {
			if (temp.next.d != i)

			{
				temp = temp.next;
			} else {
				temp.next = temp.next.next;
				break;
			}
		}

	}

	private void deleteFirst() {
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		head = temp.next.next;
		temp.next = temp.next.next;
		System.out.println("--" + temp.d);
	}

	private void deleteLast() {
		Node temp = head;

		while (temp.next.next != head) {
			temp = temp.next;
		}
		temp.next = temp.next.next;

	}

	private void addValueInMiddle(int i) {
		Node n = new Node(i);
		Node temp = head;
		while (temp.next.next.d < i) {
			temp = temp.next;
		}
		n.next = temp.next.next;
		temp.next.next = n;

	}

	private void deletEntirell() {

		Node temp=head;
		
		while(temp.next!=head)
		{
			temp=temp.next;
			//System.out.println("nik");
					
		}
		head=null;
		
		temp.next=null;
	}

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		System.out.println("---------------------------------------------------------");
		System.out.println("adding first element  in linkedlist: ");
		cll.add(10);
		cll.print();
		System.out.println("---------------------------------------------------------");
		System.out.println("Adding other elements:");
		cll.add(20);
		cll.add(30);
		cll.add(40);
		cll.add(50);
		cll.add(60);
		cll.add(70);
		cll.add(80);
		cll.add(90);
		cll.print();
		System.out.println("---------------------------------------------------------");
		System.out.println("delete a value:");
		cll.deletevalue(30);
		cll.print();
		System.out.println("---------------------------------------------------------");
		System.out.println("delete first value:");
		cll.deleteFirst();
		cll.print();
		System.out.println("---------------------------------------------------------");
		System.out.println("delete Last value:");
		cll.deleteLast();
		cll.print();
		System.out.println("---------------------------------------------------------");
		System.out.println("To add value in midlle");
		cll.addValueInMiddle(55);
		cll.print();
		System.out.println("---------------------------------------------------------");
		System.out.println("To delete entire linked list");
		cll.deletEntirell();
		//cll.print();
		System.out.println("---------------------------------------------------------");

	}

}
