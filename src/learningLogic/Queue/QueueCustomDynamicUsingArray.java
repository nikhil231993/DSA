package learningLogic.Queue;

public class QueueCustomDynamicUsingArray {
	
	private int rear=-1;	
	
	private static final int DEFAULT_SIZE = 5;
	private int[] data;
	

	public QueueCustomDynamicUsingArray() {
		this(DEFAULT_SIZE);
	}

	public QueueCustomDynamicUsingArray(int size) {
		this.data = new int[size];
	}

	public void queueEnqueue(int data) {
		if (isFull()) {

			int[] temp = new int[this.data.length * 2];
			for (int i = 0; i < this.data.length; i++)
				temp[i] = this.data[i];

			this.data = temp;
		}
		this.data[++rear]=data;
		
	}

	public int queueDequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		int itemRemoved=this.data[0];
		for(int i=0;i<this.rear;i++)
			this.data[i]=this.data[i+1];
	
				
		this.rear--;
		
		return itemRemoved;
	}

	public int queueFront() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		return this.data[0];
	}

	public boolean isEmpty() {
		return rear==-1;
	}

	public boolean isFull() {
		return rear==this.data.length-1;
	}

	public void display() {
		for(int i=0;i<this.rear;i++)
			System.out.println(this.data[i]);
	}
	

}
