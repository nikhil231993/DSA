package revision.queue;

public class CircularQueue {

	private int[] arr;
	int front = -1;
	int rear = -1;

	private static final int DEFAULT_SIZE = 5;

	public CircularQueue() {
		this(DEFAULT_SIZE);
	}

	public CircularQueue(int size) {
		this.arr = new int[size];
	}

	public boolean isEmpty() {
		if (this.rear == -1)
			return true;
		return false;
	}

	public boolean isFull() {
		if (this.rear + 1 == this.front)
			return true;
		else if (this.rear == this.arr.length - 1 && this.front == 0)
			return true;
		else
			return false;

	}
	public int queueFront() {
		
		if(isEmpty()) {
			System.out.println("Queue is empty so there is nothing to peek ");
			return -1;
		}
		return this.arr[this.front];
	}

	public void queueEnqueue(int data) {
		if (isFull()) {
			System.out.println("Cannot add element as the queue is full ");
			return;
		}
		if (front == -1) {
			front = 0;
		}

		if (this.rear == this.arr.length - 1) {
			this.rear = 0;
		} else {
			this.rear++;
		}

		this.arr[this.rear] = data;
	}

	public int queueDequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty so cannot dequeue ");
			return -1;
		}
		int removed=this.arr[this.front];
		if(this.front == this.arr.length-1) {
			this.front = 0;
		} else {
			this.front++;
		}

		return removed;
	}

}
