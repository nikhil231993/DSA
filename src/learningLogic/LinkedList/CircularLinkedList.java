package learningLogic.LinkedList;

public class CircularLinkedList {

	private Node head;
	private int size = 0;

	class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void addFirst(int data) {
		Node node=new Node(data);
		
		if(head==null) {
			node.next=head;
			head=node;
			head.next=head;
		}else {
			node.next=head;
			Node temp=head;
			while(temp.next!=head) {
				temp=temp.next;
			}
			head=node;
			temp.next=node;
		}
		size++;

	}

	public void display() {
		Node temp=head;
//		int loop=0;
//		while(loop<3) {
		while(temp.next!=head) {
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.print(temp.data+"-->");
		System.out.println("END");
//		temp=temp.next;
//		System.out.println("Loop "+ loop + " complete");
//		loop++;
//		}
	}

	public void addAtLast(int data) {
		Node node=new Node(data);
		Node temp=head;
		while(temp.next!=head) {
			temp=temp.next;			
		}
		temp.next=node;
		node.next=head;
		size++;
	}

	public void addAtPosition(int index, int data) {
		
		if(index==1) {
			addFirst(data);
			return;
		}
		if(index ==size) {
			addAtLast(data);
			return;
		}
		Node node=new Node(data);
		Node temp=head;

		for(int i=1;i<index-1;i++) {
			temp=temp.next;
		}
		node.next=temp.next;
		temp.next=node;
		size++;		
	}

	public void deleteAtFirst() {
	if(head!=null) {
		Node temp=head;
		while(temp.next!=head) {
			temp=temp.next;
		}
		temp.next=temp.next.next;
		head=head.next;
		size--;
	}else {
		System.out.println("Circular Linked List is empty");
	}
		
	}

	public void deleteAtLast() {
		Node temp=head;
		while(temp.next.next!=head) {
			temp=temp.next;
		}
		temp.next=temp.next.next;
		size--;		
	}

	public void deleteAtLast(int index) {
		if(index==1) {
			deleteAtFirst();
			return;
		}
		if(index==size) {
			deleteAtLast();
			return;
		}
		Node temp=head;
	for (int i=1;i<index-1;i++) {
		temp=temp.next;
	}
	temp.next=temp.next.next;
	size--;
		
	}

//	public void addFirst(int data) {
//
//		Node node = new Node(data);
//		Node temp = head;
//		if (head == null) {
//			node.next = head;
//			head = node;
//			node.next = head;
//		} else {
//			node.next = head;
//			while (temp.next != head) {
//				temp = temp.next;
//			}
//			head = node;
//			temp.next = head;
//		}
//		size++;
//	}

//	public void display() {
//		Node temp = head;
//		while (temp.next != head) {
//			System.out.print(temp.data + "-->");
//			temp = temp.next;
//		}
//		System.out.print(temp.data + "-->");
//		System.out.println("END");
//		System.out.println("Size is:" + size);
//
//	}
//
//	public void addAtLast(int data) {
//		Node node = new Node(data);
//		Node temp = head;
//		while (temp.next != head) {
//			temp = temp.next;
//		}
//		temp.next = node;
//		node.next = head;
//		size++;
//		System.out.println("Size is:" + size);
//	}

}
