package queue;

public class QueueCircularArrayMain {
    public static void main(String[] args) {
        QueueCircularArray queue = new QueueCircularArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();
        System.out.println("_______");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        //queue.enqueue(60);
        queue.display();
    }
}
