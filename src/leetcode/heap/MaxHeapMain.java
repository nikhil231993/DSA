package leetcode.heap;

public class MaxHeapMain {

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.insert(91);
        maxHeap.print();

        System.out.println();
        System.out.println();
        System.out.println("Peek: " + maxHeap.peek());
        System.out.println("Removing the FRONT element: " + maxHeap.remove());
        System.out.println("After max heapifying");
        maxHeap.print();
    }
}
