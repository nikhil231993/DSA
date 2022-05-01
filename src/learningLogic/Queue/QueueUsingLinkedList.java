package learningLogic.Queue;

public class QueueUsingLinkedList {
	
	
	private QueueNode front;
	private QueueNode rear;
	
	class QueueNode{
		
		private QueueNode next;
		private int data;
		
		public QueueNode(int data) {
			this.data=data;
		}
	}

	public int queueFront() {
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return -1;
		}

		return front.data;
	}

	public void queueEnqueue(int data) {
		QueueNode node=new QueueNode(data);
		if(rear==null) {
			rear=node;
			front=node;
			return;
		}
		rear.next=node;
		rear=node;
		
	}

	public int queueDequeue() {
		
		if(isEmpty())
		{
			System.out.println("Queue is empty");
			return -1;
		}
	
		int removedItem=front.data;		
		front=front.next;
		
		if(front==null)
			rear=front;
		return removedItem;
	}

	public boolean isFull() {
		return front==rear;
	}

	public boolean isEmpty() {		
		return rear==null;
	}
	
	
	

}
