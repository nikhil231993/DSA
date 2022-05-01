package learningLogic.Queue;

public class CircularQueueMain {

	public static void main(String[] args) {
		CircularQueue queue=new CircularQueue();
		System.out.println("Before adding elements :"+queue.isEmpty());
		System.out.println("Before adding elements queueFront: ");
		System.out.println(queue.queueFront());

		queue.queueEnqueue(1);
		queue.queueEnqueue(11);
		queue.queueEnqueue(21);
		queue.queueEnqueue(31);
		queue.queueEnqueue(41);	
		queue.queueEnqueue(51);	

		System.out.println("Removed items are");
		System.out.println(queue.queueDequeue());
		queue.queueEnqueue(51);
		queue.queueEnqueue(61);
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());


		System.out.println("queueFront: ");
		System.out.println(queue.queueFront());
		System.out.println(queue.isFull());
		System.out.println(queue.isEmpty());
		

	}

}
