package leetcode.heap.codehelp;

public class L75MergeTwoBinaryHeaps {

    public static void main(String[] args) {

        int n = 4, m = 3;
        int a[] =new int[] {10, 5, 6, 2};
        int b[] = new int[] {12, 7, 9};

        //Approach 1
        //Merge to one array and Arrays.sort()  TC:O(n log n)

        //Approach 2
        int[] result=mergeHeaps(a,b,n,m);
        for(Integer num:result)
            System.out.println(num);
    }

    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {

        int[] arr=new int[n+m];
        int i=0;
        for(Integer num: a){
            arr[i++]=num;
        }
        for(Integer num:b){
            arr[i++]=num;
        }
        buildHeap(arr, arr.length);
        return arr;

        // TC:O(n+m) build heap time complexity + O(n) to for arr array
        // SC:O(n+m)
    }

    public static void buildHeap(int[] arr, int size){

        for(int i=size/2-1;i>=0;i--){
            heapify(arr,size,i);
        }
    }

    public static void heapify(int[] arr, int size, int index){

        int largest=index, left=2*index+1, right=2*index+2;

        if(left < size && arr[largest]<arr[left])
            largest=left;

        if(right < size && arr[largest]<arr[right])
            largest=right;

        if(largest!=index){
            int temp=arr[index];
            arr[index]=arr[largest];
            arr[largest]=temp;
            heapify(arr,size,largest);
        }
    }
}
