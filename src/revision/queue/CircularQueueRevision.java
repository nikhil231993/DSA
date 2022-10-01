package revision.queue;

public class CircularQueueRevision {

	private int[] arr;
	int front = -1;
	int rear = -1;

	private static final int DEFAULT_SIZE = 5;

	public CircularQueueRevision() {
		this(DEFAULT_SIZE);
	}

	public CircularQueueRevision(int size) {
		this.arr = new int[size];
	}

	public boolean isEmpty() {
		if (this.rear == -1)
			return true;
		return false;
	}

	public int queueFront() {
		if (isEmpty()) {
			System.out.println("Nothing to peek as queue is empty ");
			return -1;
		}

		return this.arr[this.front];
	}

	public void queueEnqueue(int data) {
		if (isFull()) {
			System.out.println("Queue is full so cannot add element ");
			return;
		}
		
		if (this.front == -1) {
			this.front = 0;
		}
		if (this.rear == arr.length - 1) {
			this.rear = 0;
		} else {
			this.rear++;
		}
		this.arr[this.rear] = data;

	}

	public boolean isFull() {
		if (this.front == 0 && this.rear == this.arr.length - 1)
			return true;
		else if (this.rear + 1 == this.front)
			return true;
		else
			return false;
	}

	public int queueDequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty so nothing to dequeue ");
			return -1;
		}
		int removed = this.arr[this.front];
		if (this.front == this.arr.length - 1) {
			this.front = 0;
		} else if (this.front == this.rear) { // if there is only 1 element in Queue
			this.front = this.rear = -1;
		}else {
		
			this.front++;
		}

		return removed;
	}
}
