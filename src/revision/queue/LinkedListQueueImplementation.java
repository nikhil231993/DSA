package revision.queue;

public class LinkedListQueueImplementation {

	private Node front;
	private Node rear;
	private class Node {

		int data;
		Node next;

		private Node(int data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		if (this.front == null)
			return true;
		return false;

	}

	public int queueFront() {
		if (!isEmpty())
			return front.data;
		return -1;
	}

	public void queueEnqueue(int data) {
		Node node = new Node(data);
		if (rear == null) {
			front = node;
			rear = node;
			return;
		}
		rear.next = node;
		rear = node;

	}

	public int queueDequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty ");
			return -1;
		}
		int value = front.data;
		front = front.next;
		return value;
	}

}
