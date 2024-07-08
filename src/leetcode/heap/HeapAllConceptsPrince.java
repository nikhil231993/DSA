package leetcode.heap;

public class HeapAllConceptsPrince {

    private static int[] arr=null;

    private static int size;

    private static int capacity;

    public HeapAllConceptsPrince(int cap){

        capacity=cap;
        size=0;
        arr=new int[cap];
    }

    private int left(int i){
        return 2*i+1;
    }

    private int right(int i){
        return 2*i+2;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    public void insert(int value){

        if(size==capacity)
            System.out.println("Heap is full");
        arr[size++]=value;
        heapifyUp(size-1);

        //TC:O(log n)
        //SC:O(1) as we are using already present array.
    }

    private void heapifyUp(int index) {

        while(index!=0 && arr[(index-1)/2]>arr[index]){
            int temp=arr[(index-1)/2];
            arr[(index-1)/2]=arr[index];
            arr[index]=temp;
            index=(index-1)/2;
            //TC:O(log n) .ie., Height of the tree
            //SC:O(1) as we are using already present array.
        }
    }

    private void print(){

        System.out.println("Heap is: ");
        for(int i=0;i<=size/2-1;i++){
            System.out.println("Parent is : "+ arr[i]);
            if(2*i+1<size)
                System.out.println("Left node is : "+ arr[2*i+1]);
            if(2*i+2<size)
                System.out.println("Right node is : "+arr[2*i+2]);
        }
    }

    public int getMin(){

        if(size==0)
            return -1;
        return arr[0];

        //TC:O(1)
        //SC:O(1)
    }


    private int extractMin() {

        if(size==0)
            return -1;

        int removed=arr[0];
        arr[0]=arr[--size];
        heapifyTopToBottom(0);
        return removed;

        //TC:O(log n)
        //SC:O(log n) due recursive heap call
    }

    private static void heapifyTopToBottom(int index) {

        int left=2*index+1;
        int right=2*index+2;
        int smallest=index;

        if(left < size && arr[left] < arr[smallest]){
            smallest=left;
        }
        if(right < size && arr[right] < arr[smallest]){
            smallest=right;
        }
        if(smallest!=index){
            int temp=arr[smallest];
            arr[smallest]=arr[index];
            arr[index]=temp;
            heapifyTopToBottom(smallest);
        }

        //TC:O(log n)
        //SC:O(log n)
    }

    private void decreaseKey(int index, int value) {

        if(index==capacity)
            System.out.println("Cannot insert");
        arr[index]=value;
        heapifyUp(index);
        //TC:O(log n)
        //SC:O(n)
    }

    private void deleteKey(int index) {

        decreaseKey(index,-Integer.MIN_VALUE);
        extractMin();
        //TC:O(log n)
        //SC:O(log n) for heapify call
    }

    public static void main(String[] args) {

        HeapAllConceptsPrince h=new HeapAllConceptsPrince(10);
        h.insert(4);
        h.insert(10);
        h.insert(2);
        h.insert(6);
        h.insert(7);
        h.insert(3);
        h.insert(8);
        h.insert(5);
        h.print();

        System.out.println("Min is : " + h.getMin());
        System.out.println("Value has been extracted : " + h.extractMin());
        h.print();
        System.out.println("After decrease key operation : ");
        h.decreaseKey(3,1);
        h.print();
        System.out.println("After delete key operation : ");
        h.deleteKey(4);
        h.print();
    }
}
