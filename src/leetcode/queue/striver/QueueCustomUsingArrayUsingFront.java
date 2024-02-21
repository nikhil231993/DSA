package leetcode.queue.striver;

public class QueueCustomUsingArrayUsingFront {

	private static final int DEFAULT_SIZE = 5;
	private int rear = -1;
	private int front = -1;
	private int[] arr;

	public QueueCustomUsingArrayUsingFront() {
		this(DEFAULT_SIZE);
	}

	public QueueCustomUsingArrayUsingFront(int size) {
		arr = new int[size];
	}

	public boolean isEmpty() {
		return this.rear == -1;
	}

	public boolean isFull() {
		return this.rear == this.arr.length - 1;
	}

	public int queueFront() {

		if (isEmpty()) {
			System.out.println("Queue is empty: ");
			return -1;
		}
		return this.arr[this.front];
	}

	public void queueEnqueue(int value) {

		if (isFull()) {
			System.out.println("Queue is full ");
			return;
		}

		if (this.front == -1) {
			this.front = 0;
		}

		this.arr[++this.rear] = value;
		System.out.println(value + " added into queue ");
	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Queue is empty. Nothing to display. ");
			return;
		}
		System.out.println("Value in queue from start are: ");
		for (int i = this.front; i <= rear; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public int queueDequeue() {
		// ++this.front;

		if (isEmpty()) {
			System.out.println("Queue is empty. Nothing to dequeue. ");
			return -1;
		}
		
		if(front> rear) {
			System.out.println("Front is greater than rear. So queue is empty.");
			this.front=-1;
			this.rear = -1;
			return -1;
		}

		return this.arr[this.front++];
	}
}
