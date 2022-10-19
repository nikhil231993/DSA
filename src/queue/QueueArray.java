package queue;

public class QueueArray {
    int[] queue;
    int front = -1;
    int rear = -1;
    public QueueArray(int size) {
        queue = new int[size];
    }

    public boolean isFull() {
        if (rear == queue.length-1) {
            return true;
        }
        return  false;
    }

    public boolean isEmpty() {
        if (rear == -1) {
            return true;
        }
        return false;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full");
        }
        if (isEmpty()) {
            front ++;
        }
        queue[++rear] = data;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        int value = queue[front];
        front ++;
        return value;
    }
    public void display() {
        System.out.println("Final Queue");
        for (int i = front; i <= rear; i ++) {
            System.out.printf("%d -->", queue[i]);
        }
    }
}
