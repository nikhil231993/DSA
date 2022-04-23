package learningLogic.LinkedList;

public class DoublyLinkedList {

	private Node head;

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
		node.prev = null;
		if (head != null) {
			head.prev = node;
		}
		head = node;

		size++;

	}

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println("END");
	}

	public void reverseDsiplay() {
		Node temp = head;
		Node last = null;
		while (temp != null) {

			last = temp;
			temp = temp.next;
		}

		while (last != null) {
			System.out.print(last.data + "-->");
			last = last.prev;
		}
		System.out.println("START");

	}

	public void addLast(int value) {
		Node node=new Node(value);
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=node;
		node.prev=temp;
		node.next=null;		
		size++;
		
	}

	public void addAtParticularPos(int pos, int value) {
		Node node=new Node(value);
		Node temp=head;
		int index=0;
		if(pos ==1) {
			addFirst(value);
			return;
		}
		
		if(pos == size+1)
		{
			addLast(value);
			return;
		}
		for(int i=1;i<pos-1;i++) {
			temp=temp.next;
		}
		
		node.next=temp.next;
 		if(node.next!=null)
			node.next.prev=node;
		temp.next=node;
		node.prev=temp;
		size++;
		
	}

	public void deleteFirst() {

		if(head!=null) {
			head.next.prev=null;
			head=head.next;
			size--;
		}else
			System.out.println("LinkedList is empty");
		
	}

	public void deleteAtLast() {
		Node temp=head;
		while(temp.next.next!=null)
		{
			temp=temp.next;
		}
		temp.next.prev=null;
		temp.next=null;
		size--;
		
	}

	public void deletAtIndex(int index) {
		
		Node temp=head;
	if(index==1)
	{
		deleteFirst();
		return;
	}
	if(index==size) {
		deleteAtLast();
		return;
	}
	
	for (int i=1;i<index-1;i++) {
		temp=temp.next;
	}
	
	temp.next.next.prev=temp;
	temp.next=temp.next.next;
	size--;
	}

}
