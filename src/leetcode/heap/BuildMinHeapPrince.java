package leetcode.heap;

public class BuildMinHeapPrince {

    public static void main(String[] args) {

        int[] arr=new int[]{9, 3, 2, 5, 4, 6, 7, 8, 1};
        int lastInternalNode=arr.length/2-1;

        for(int i=lastInternalNode; i>=0; i--){
            minHeapify(arr,arr.length,i);
        }
        System.out.println("Min Heap is : ");
        print(arr.length,arr);

        //Time complexity for build heap is O(n) which is as per proof
        //SC:O(log n)
    }

    private static void print(int size,int[] arr){

        System.out.println("Heap is: ");
        for(int i=0;i<=size/2-1;i++){

            System.out.println("Parent is : "+ arr[i]);
            if(2*i+1<size)
                System.out.println("Left node is : "+ arr[2*i+1]);
            if(2*i+2<size)
                System.out.println("Right node is : "+arr[2*i+2]);
        }
    }
    private static void minHeapify(int[] arr, int n, int index) {

        int left=2*index+1, right=2*index+2, smallest=index;

        if(left<n && arr[left]<arr[smallest])
            smallest=left;

        if(right<n && arr[right]<arr[smallest])
            smallest=right;

        if(smallest!=index){
            int temp=arr[smallest];
            arr[smallest]=arr[index];
            arr[index]=temp;
            minHeapify(arr,n,smallest);
        }
    }
}
