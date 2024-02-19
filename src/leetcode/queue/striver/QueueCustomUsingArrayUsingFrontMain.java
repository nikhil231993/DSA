package leetcode.queue.striver;

public class QueueCustomUsingArrayUsingFrontMain {

	public static void main(String[] args) {

		QueueCustomUsingArrayUsingFront queue = new QueueCustomUsingArrayUsingFront(14);
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
		System.out.println(queue.queueDequeue());// 0 because its dynamic queue
		System.out.println(queue.queueDequeue());// 0 beacuse its dynamic queue

		System.out.println("queueFront: ");
		System.out.println(queue.queueFront());
		System.out.println(queue.isFull());
		System.out.println(queue.isEmpty());

		queue.queueEnqueue(804);
		queue.display();

	}

}
