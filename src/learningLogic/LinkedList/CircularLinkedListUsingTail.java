package learningLogic.LinkedList;

public class CircularLinkedListUsingTail {

	private Node head;
	private Node tail;
	private int size;

	class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public void addFirst(int data) {
		Node node = new Node(data);
		if (head == null) {
			head = node;
			tail = node;
			node.next = head;
			size++;
			return;
		}

		node.next = head;
		tail.next = node;
		head = node;
		size++;

	}

	public void display() {
		Node temp = head;
		while (temp.next != head) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.print(temp.data+"-->");
		System.out.println("END");
	}

	public void addAtLast(int data) {
		Node node =new Node(data);
		tail.next=node;
		node.next=head;
		tail=node;
		size++;	
		
	}

	public void addAtPosition(int index, int data) {
		if(index==1) {
			addFirst(data);
			return;
		}
		if(index==size) {
			addAtLast(data);
			return;
		}
		Node temp=head;
		Node node=new Node(data);
		for(int i=1;i<index-1;i++) {
			temp=temp.next;
		}
		
		node.next=temp.next;
		temp.next=node;
		size++;
	
		
	}

	public void deleteAtFirst() {
		tail.next=head.next;
		head=head.next;
		size--;		
	}

	public void deleteAtLast() {
		Node temp=head;
		while(temp.next.next!=head) {
			temp=temp.next;
		}		
		temp.next=head;
		tail=temp;
		size--;		
		
	}

	public void deleteAtLast(int index) {
		if(index==1) {
			deleteAtFirst();;
			return;
		}
		if(index==size) {
			deleteAtLast();
			return;			
		}
		Node temp=head;
		for(int i=1;i<index-1;i++) {
			temp=temp.next;
		}
		
		temp.next=temp.next.next;
		size--;
		
	}


}
