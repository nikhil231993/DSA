package leetcode.sortingtechniques;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr=new int[]{100, 3, 4, 2, 5, 6, 29, 47, 100, 201};;
        int n=arr.length;

        heapSort(arr, n);
        for(int num : arr)
            System.out.println(num);
    }

    public static void heapSort(int[] arr, int n){

        //build max Heap
        buildMaxHeap(arr, n);
        for(int i=n-1; i>0; i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxHeapify(arr, 0, i);
        }
    }

    private static void buildMaxHeap(int[] arr, int n) {

        for(int index=n/2-1; index>=0; index--)
            maxHeapify(arr, index ,n);
    }

    private static void maxHeapify(int[] arr, int i, int n){

        int largest=i;

        int left=2*i+1;
        int right=2*i+2;

        if(left < n && arr[left] > arr[i])
            largest=left;

        if(right < n && arr[right] > arr[i])
            largest=right;

        if(largest!=i){
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;
            maxHeapify(arr, largest, n);
        }
    }
}
