package queue;

public class QueueLinkedListMain {
    public static void main(String[] args) {
        QueueLinkedList queueLinkedList = new QueueLinkedList();
        queueLinkedList.enqueueLL(10);
        queueLinkedList.displayLL();
        queueLinkedList.enqueueLL(20);
        queueLinkedList.enqueueLL(30);
        queueLinkedList.enqueueLL(40);
        System.out.println();
        queueLinkedList.displayLL();
        queueLinkedList.dequeueLL();
        System.out.println();
        queueLinkedList.displayLL();
    }
}
