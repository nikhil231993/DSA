package learningLogic.Stack;

public class CustomStack {

	protected int[] data;
	private int top = -1;
	private static final int DEFAULT_SIZE = 10;

	public CustomStack() {
		this(DEFAULT_SIZE);
	}

	public CustomStack(int size) {
		this.data = new int[size];
	}

	public void push(int value) {
		if (isFull()) {
			System.out.println("Stack is full");
			return;
		}
		this.data[++this.top] = value;

	}

	public boolean isFull() {
		return this.top == this.data.length - 1;
	}

	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int value = this.data[this.top--];
		return value;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int value = this.data[this.top--];
		return value;
	}

}
