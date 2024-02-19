package leetcode.queue.striver;

public class CircularQueueUsingModulo {

	private int[] arr;
	int front = -1;
	int rear = -1;

	private static final int DEFAULT_SIZE = 5;

	public CircularQueueUsingModulo() {

		this(DEFAULT_SIZE);
	}

	public CircularQueueUsingModulo(int size) {

		this.arr = new int[size];
	}

	public boolean isEmpty() {
		if (this.rear == -1)
			return true;
		return false;
	}

	public int queueFront() {

		if (isEmpty()) {
			System.out.println("Queue is empty cannot peek at this moment ");
			return -1;
		}
		return this.arr[this.front];
	}

	public void queueEnqueue(int value) {

		if(isFull()) {
			System.out.println("Queue is full cannot enqueue ");
			return;
		}
		if(front ==-1) {
			front = 0;
		}
		
		this.rear=(this.rear+1)%this.arr.length;
		this.arr[this.rear]=value;
	}

	public boolean isFull() {
		return (this.rear + 1) % this.arr.length == this.front;
	}

	public int queueDequeue() {

		if (isEmpty()) {
			System.out.println("Cannot qeueue as the queue is empty ");
			return -1;
		}
		int removed = this.arr[front];

		if (front == rear) {
			rear = front = -1;
		} else {
			front = (front + 1) % this.arr.length;
		}
		return removed;
	}
}
