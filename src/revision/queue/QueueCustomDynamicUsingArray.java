package revision.queue;

public class QueueCustomDynamicUsingArray {

	private static final int DEFAULT_SIZE = 5;
	private int rear = -1;
	private int[] arr;

	public QueueCustomDynamicUsingArray() {
		this(DEFAULT_SIZE);
	}

	public QueueCustomDynamicUsingArray(int size) {
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
		return this.arr[0];
	}

	public void queueEnqueue(int value) {

		if (isFull()) {
			System.out.println("Queue is full ");
			return;
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
		for (int i = 0; i <= rear; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public int queueDequeue() {

		if (isEmpty()) {
			System.out.println("Queue is empty. Nothing to dequeue. ");
			return -1;
		}
		int value = this.arr[0];

		for (int i = 0; i < this.rear; i++) {
			this.arr[i] = this.arr[i + 1];
		}
		this.rear--;

		return value;
	}

}
