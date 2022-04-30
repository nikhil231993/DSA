package learningLogic.LinkedList;

public class CircularDoublyLinkedListUsingTail {
	
	//TestB
	private Node head;
	private Node tail;

	private int size;

	private class Node {
		private int data;
		private Node next;
		private Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	public void addFirst(int value) {
		Node node = new Node(value);

		node.next = head;
		if (head == null) {
			head = node;
			tail = node;
			head.next = head;
			head.prev=tail;
		} else {
			head.prev = node;
			head = node;
			tail.next = node;
			head.prev=tail;
		}

		size++;

	}

	public void display() {
		Node temp = head;
		while (temp.next != head) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.print(temp.data + "-->");
		System.out.println("END");
	}

	public void addAtLast(int data) {
		Node node = new Node(data);
		if (head != null) {
			tail.next = node;
			node.prev = tail;
			node.next = head;
			tail = node;
			head.prev=tail;

		} else {
			addFirst(data);
			return;
		}
		size++;

	}

	public void addAtPosition(int index, int data) {
		if (index == 1) {
			addFirst(data);
			return;
		} else if (index == size) {
			addAtLast(data);
			return;
		}
		Node temp = head;
		Node node = new Node(data);

		for (int i = 1; i < index - 1; i++) {
			temp = temp.next;
		}

		node.prev = temp;
		node.next = temp.next;
		temp.next = node;
		if (node.next != null)
			node.next.prev = node;

		size++;

	}

	public int searchValue(int value) {
		Node temp = head;
		int loc = 0;
		do {
			loc++;
			if (temp.data == value) {
				return loc;
			}
			temp = temp.next;
		} while (temp != head);
		return -1;

	}

	public void deleteAtFirst() {
		if (head == null || tail == null) {
			System.out.println("Doubly Linked List is empty");
		}

		tail.next = head.next;
		head = head.next;
		head.prev = tail;
		size--;

	}

	public void deleteAtLast() {
		if (head == null || tail == null) {
			System.out.println("Doubly Linked List is empty");
		}

		Node temp = head;
		while (temp.next.next != head) {
			temp = temp.next;
		}
		tail = temp;
		tail.next = head;
		head.prev=tail;
		size--;

	}

	public void deleteAtLoc(int index) {
		
		Node temp=head;
		if(index==1) {
			deleteAtFirst();
			return;
		}
		else if (index ==size) {
			deleteAtLast();
			return;
		}
		for(int i=1;i<index-1;i++)
		{
			temp=temp.next;
		}
		
		temp.next.next.prev=temp;
		temp.next=temp.next.next;
		size--;
	}

	public void reverseDisplayFromHead() {
		Node temp=head;
		do {
			temp=temp.prev;
			System.out.print(temp.data+"-->");			
		}while(temp!=head);
		
			System.out.println("START");
		
	}

}
