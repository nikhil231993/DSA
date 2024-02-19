package leetcode.queue.striver;

public class QueueCustomUsingArray {

	private static final int DEFAULT_SIZE = 5;
	private int top = -1;
	private int[] arr;

	public QueueCustomUsingArray() {
		this(DEFAULT_SIZE);
	}

	public QueueCustomUsingArray(int size) {
		this.arr = new int[size];
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public boolean isFull() {
		return this.top == this.arr.length - 1;
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

		this.arr[++this.top] = value;
		System.out.println(value + " added into queue ");
	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Queue is empty. Nothing to display. ");
			return;
		}
		System.out.println("Value in queue from start are: ");
		for (int i = 0; i <= top; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public int queueDequeue() {

		if (isEmpty()) {
			System.out.println("Queue is empty. Nothing to dequeue. ");
			return -1;
		}
		int value = this.arr[0];

		//Remove the element from the first and move the entire array to left by one place
		//This is if you are using only one pointer
		for (int i = 0; i < this.top; i++) {
			this.arr[i] = this.arr[i + 1];
		}

		this.top--;

		return value;
	}

}
