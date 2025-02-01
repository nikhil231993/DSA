package leetcode.heap.easy;

public class MinHeapToMaxHeap {

    public static void main(String[] args) {

        int[] arr=new int[]{1, 2 ,3 ,4 ,5 ,6};
        int[] r=minToMaxHeap(arr.length, arr);

        for(int num:r)
            System.out.println(num);
    }

    public static int[] minToMaxHeap(int n, int[] arr){

        int lastInternalNode=arr.length/2-1;
        for(int i=lastInternalNode;i>=0;i--){
            maxHeapify(arr,arr.length,i);
        }
        return arr;

        //TC:O(n log n)
        //SC:O(1)
    }

    private static void maxHeapify(int[] arr, int n, int index) {

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left<n && arr[left]>arr[largest])
            largest = left;

        if (right<n && arr[right]>arr[largest])
            largest = right;

        if (largest != index) {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            maxHeapify(arr, n, largest);
        }
    }
}
