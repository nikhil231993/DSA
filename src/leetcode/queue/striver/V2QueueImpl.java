package leetcode.queue.striver;

class QueueUsingArray {

	private int[] arr = null;
	private int front;
	private int rear;

	public QueueUsingArray(int size) {
		arr = new int[size];
		front = -1;
		rear = -1;
	}

	public void push(int data) {

		if (isFull()) {
			System.out.println("Queue is full");
			return;
		}

		if (this.front == -1)
			this.front = 0;

		this.rear = (this.rear + 1) % this.arr.length;

		arr[this.rear] = data;
	}

	public boolean isFull() {

		if ((this.rear + 1) % this.arr.length == this.front)
			return true;
		return false;
	}

	public int pop() {

		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}

		int removed = arr[this.front];

		if (this.front == this.rear) {
			this.front = -1;
			this.rear = -1;
			return removed;
		}

		this.front = (this.front + 1) % arr.length;

		return removed;
	}

	public boolean isEmpty() {

		if (this.rear == -1)
			return true;
		return false;
	}

	public int top() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return arr[this.front];
	}
}

public class V2QueueImpl {

	public static void main(String[] args) {

		QueueUsingArray q = new QueueUsingArray(5);
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.push(5);
		q.push(6);
		q.push(7);
		q.push(8);
		q.push(9);
		q.push(10);

		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());

		System.out.println(q.top());

		System.out.println(q.top());

		q.push(6);
		q.push(7);
		q.push(8);
		q.push(9);
		q.push(10);

		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		
		System.out.println(q.isEmpty());
		System.out.println(q.isFull());

	}
}
