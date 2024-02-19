package leetcode.heap;

public class HeapSort {

    //Step 1: Build MaxHeap
    //Step 2: Swap max element with last element
    //Step 3: call heapify with index=0 and reduced size

    public static void main(String[] args) {

        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17} ;

        int n = arr.length   ;
        heapSort(arr, n)  ;
        System.out.println("Heap after Sorting is :")  ;
        print(arr, n)  ;

        System.out.println("Array after sorting is : ");
        for(int num:arr)
            System.out.println(num);
    }

    private static void print(int[] arr,int n){

        System.out.println("Heap is: ");
        for(int i=0;i<=n/2-1;i++){
            System.out.println("Parent is : "+ arr[i]);
            if(2*i+1<n)
                System.out.println("Left node is : "+ arr[2*i+1]);
            if(2*i+2<n)
                System.out.println("Right node is : "+arr[2*i+2]);
        }
    }

    private static void heapSort(int[] arr, int n) {

        buildHeap(arr,n);
        for(int i=n-1;i>0;i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(arr,0,i);
        }
        //TC:O(nlogn)
    }

    private static void buildHeap(int[] arr, int n) {

        for(int i=n/2-1; i>=0;i--)
            heapify(arr,i,arr.length);

        System.out.println("Heap built is : ");
        print(arr, n);
    }

    private static void heapify(int[] arr, int index, int n) {

        int left=2*index+1;
        int right=2*index+2;
        int largest=index;
        if(left<n && arr[left]>arr[largest]){
            largest=left;
        }
        if(right<n && arr[right]>arr[largest]){
            largest=right;
        }
        if(largest!=index){
            int temp=arr[largest];
            arr[largest]=arr[index];
            arr[index]=temp;
            heapify(arr,largest,n);
        }
    }
}
