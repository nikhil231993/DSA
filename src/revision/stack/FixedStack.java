package revision.stack;

public class FixedStack {

	protected int[] arr;
	int top = -1;
	private static final int DEFAULT_SIZE = 10;

	public FixedStack() {
		this(DEFAULT_SIZE);
	}

	public FixedStack(int size) {
		arr = new int[size];
	}

	public void push(int data) {
		if (isFull()) {
			System.out.println("Stack is full");
		}else {
			arr[++this.top] = data;
		}
	}
	
	
	public boolean isFull() {
		if (this.top == this.arr.length - 1)
			return true;
		return false;
	}

	public int pop() {
		int value = 0;
		if (isEmpty()) {
			System.out.println("Stack is empty ");
			return -1;
		}

			value = this.arr[this.top];
			--this.top;
			return value;

	}

	public boolean isEmpty() {
		if (this.top == -1)
			return true;
		return false;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty: ");
			return -1;
		}
		return this.arr[top];
	}

}
