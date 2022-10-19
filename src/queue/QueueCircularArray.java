package queue;

public class QueueCircularArray {
    int[] queue;
    int front = -1;
    int rear = -1;
    public QueueCircularArray(int size) {
        queue = new int[size];
    }

    public boolean isFull() {
        int size = queue.length;
        if (rear+1/size == front) {
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
        if (front == -1) {
            front ++;
        }
        rear = rear+1%queue.length;
        queue[rear] = data;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        if (front == rear) {
            int val = queue[front];
            front = rear = -1;
            return val;
        }
        int value = queue[front];
        front = front +1 %queue.length;
        return value;
    }
    public void display() {
        System.out.println("Final Queue");
        for (int i = front; i <= rear; i ++) {
            System.out.printf("%d -->", queue[i]);
        }
    }
}
