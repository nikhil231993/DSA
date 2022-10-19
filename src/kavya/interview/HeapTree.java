package kavya.interview;

public class HeapTree {
    int[] arr;
    int sizeOfTree;

    public HeapTree(int size) {
        this.arr = new int[size+1];
        this.sizeOfTree = 0;
    }

    private void insertInHeap(int value) {
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
//        System.out.println("sizeOfTree " + sizeOfTree);
        HeapifyBottomToTop(sizeOfTree);

    }

    private void levelOrder() {
        System.out.println("sizeOfTree: " + sizeOfTree);
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    private void HeapifyBottomToTop(int sizeOfTree) {
        if(sizeOfTree <=1)
            return;
        int parent = sizeOfTree/2;
        if(arr[sizeOfTree] < arr[parent]) {
            int temp = arr[sizeOfTree];
            arr[sizeOfTree] = arr[parent];
            arr[parent] = temp;
        }
        HeapifyBottomToTop(parent);
    }

    private int extractMin() {
        if(sizeOfTree == 0) {
            System.out.println("Heap is empty");
            return -1;
        } else {
            int minValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            HeapifyTopToBottom(1);
            return minValue;
        }
    }

    private void HeapifyTopToBottom(int index) {
        int left = 2*index;
        int right = (2*index)+1;
        int small = 0;
        if(left > sizeOfTree) { //no child
            return;
        } else if (sizeOfTree == left) { //only one child
            if(arr[index] > arr[left]) {
                int temp = arr[index];
                arr[index] =  arr[left];
                arr[left] = temp;
            }
            return;
        } else {
            if(arr[left] < arr[right])
                small = left;
            else
                small = right;
            if(arr[index] > arr[small]) {
                int temp = arr[index];
                arr[index] =  arr[small];
                arr[small] = temp;
            }
        }
        HeapifyTopToBottom(small);
    }

    //driver method
    public static void main(String[] args) {
        HeapTree heap = new HeapTree(10);
//        heap.insertInHeap(100);
//        heap.insertInHeap(110);
        heap.insertInHeap(100);
        heap.insertInHeap(90);
        heap.insertInHeap(80);
        heap.insertInHeap(70);
        heap.insertInHeap(60);
        heap.insertInHeap(50);
        heap.insertInHeap(40);
        heap.insertInHeap(30);
        heap.insertInHeap(20);
        heap.insertInHeap(100);
        heap.levelOrder();
        int min = heap.extractMin();
        System.out.println("Minvalue: " + min);
        System.out.println("---------------");
        heap.levelOrder();
    }

}
