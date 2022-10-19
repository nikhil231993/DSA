package queue;

public class QueueLinkedList {
    private Node front;
    private Node rear;
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data =data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        if (rear == null) {
            return true;
        }
        return false;
    }

    public void enqueueLL(int data) {
        Node node =  new Node(data);
        if (rear == null) {
            rear = front =node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    public int dequeueLL() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return -1;
        }
        int val = front.data;
        front = front.next;
        return val;
    }

    public void displayLL() {
        Node temp = front;
        while (temp != null) {
            System.out.printf("%d --> ", temp.data);
            temp = temp.next;
        }
    }
}
