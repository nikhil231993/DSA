package learningLogic.Queue;

public class CircularQueue {

	private int[] data;
	private int front = -1;
	private int rear = -1;
	private static final int DEFAULT_SIZE = 5;

	public CircularQueue() {
		this(DEFAULT_SIZE);
	}

	public CircularQueue(int size) {
		this.data = new int[size];
	}

	public int queueFront() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}

		return this.data[this.front];
	}

	public boolean isEmpty() {
		return rear == -1 && front == -1;
	}

	public void queueEnqueue(int data) {
		if (isFull()) {
			System.out.println("Circular queue is full");
			return;
		}

		if (front == -1) {
			front = 0;
		}
		rear = (rear + 1) % this.data.length;
		this.data[rear] = data;

	}

	public int queueDequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int removed = this.data[front];

		if (front == rear) {
			rear = front = -1;
		} else {
			front = (front + 1) % this.data.length;
		}

		return removed;
	}

	public boolean isFull() {
		return (rear + 1) % this.data.length == front;
	}

}
