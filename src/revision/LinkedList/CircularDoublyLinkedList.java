package revision.LinkedList;

public class CircularDoublyLinkedList {

	int size;
	Node head;
	private class Node {

		Node prev;
		Node next;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void addFirst(int data) {
		Node node =new Node(data);
		if (head == null) {
			node.next = head;
			head = node;
			node.next = head;
			node.prev = head;
			size++;
		} else {
			// head.prev = node;
			node.next = head;
			Node temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = node;
			node.prev = head.prev;
			head.prev = node;
			head = node;
			size++;
		}

	}

	public void display() {
		if(head==null) {
			System.out.println("CDLL is empty");
			return;
		}
		Node temp = head;
		while (temp.next != head) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data + "-->");

	}

	public void addAtLast(int data) {
		Node node = new Node(data);
		Node temp=head;
		while (temp.next != head) {
			temp = temp.next;
		}

		node.prev = temp;
		temp.next = node;
		node.next = head;
		head.prev = node;
		size++;

	}

	public void addAtPosition(int pos, int data) {
		Node node = new Node(data);
		Node temp = head;
		if (pos == 1) {
			addFirst(data);
			return;
		} else if (pos == size + 1) {
			addAtLast(data);
			return;
		} else {
			for (int i = 1; i < pos - 1; i++) {
				temp = temp.next;
			}

			temp.next.prev = node;
			node.prev = temp;
			node.next = temp.next;
			temp.next = node;
			size++;

		}

	}

	public int searchValue(int data) {
		Node temp = head;
		int pos = 1;
		while (temp.next != head) {
			if (temp.data == data) {
				return pos;
			}
			temp = temp.next;
			pos++;
		}
		return -1;
	}

	public void reverseDisplayFromHead() {
		if (head == null) {
			System.out.println("CDLL is empty");
			return;
		}

		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}
		while (temp != head) {
			System.out.print(temp.data + "-->");
			temp = temp.prev;
		}
		System.out.println(temp.data + "-->");

	}

	public void deleteAtFirst() {

		if (head.next == head) {
			head.prev = null;
			head.next = null;
			head = null;
			return;
		}
		Node temp = head;
		while (temp.next != head) {
			temp = temp.next;
		}

		temp.next = temp.next.next;

		// temp.next.next.prev = null; bug found
		temp.next.next.prev = temp;
		head = head.next;
		size--;
	}

	public void deleteAtLast() {
		Node temp = head;
		while (temp.next.next != head) {
			temp = temp.next;
		}

		head.prev = temp;
		temp.next = head;
		size--;
	}

	public void deleteAtLoc(int pos) {
		Node temp=head;
		if(pos==1)
		{
			deleteAtFirst();
			return;
		} else if (pos == size + 1) {
			deleteAtLast();
			return;
		} else {
			for(int i=1;i<pos-1;i++) {
				temp=temp.next;
			}
			temp.next.next.prev=temp;
			temp.next = temp.next.next;
			size--;

		}

	}

}
