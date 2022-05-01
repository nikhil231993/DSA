package learningLogic.Queue;

public class QueueUsingLinkedListMain {
	


	public static void main(String[] args) {
		QueueUsingLinkedList queue=new QueueUsingLinkedList();
		System.out.println("Before adding elements :"+queue.isEmpty());
		System.out.println("Before adding elements queueFront: ");
		System.out.println(queue.queueFront());

		queue.queueEnqueue(1);
		queue.queueEnqueue(10);
		queue.queueEnqueue(100);
		queue.queueEnqueue(1000);
		queue.queueEnqueue(10000);
		queue.queueEnqueue(8);
		queue.queueEnqueue(80);	
		queue.queueEnqueue(800);
		queue.queueEnqueue(809);
		queue.queueEnqueue(808);
		queue.queueEnqueue(807);
		queue.queueEnqueue(806);
		queue.queueEnqueue(805);
		queue.queueEnqueue(804);
		

		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());
		System.out.println(queue.queueDequeue());

		System.out.println("queueFront: ");
		System.out.println(queue.queueFront());
		System.out.println(queue.isFull());
		System.out.println(queue.isEmpty());

	}



}
