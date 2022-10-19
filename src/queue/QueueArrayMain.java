package queue;

public class QueueArrayMain {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);
        queue.dequeue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();
        queue.dequeue();
        queue.display();
    }
}
