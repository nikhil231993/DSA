package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC215KLargestElement {

    public static void main(String[] args) {

        //Approach 1:Sort the array and find the answer
        //nums[n-k]

        //Approach 1 : Using custom heap sort
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        int n=nums.length;

        //Approach 2: using max heap custom heap
        int r1=usingCustomHeap(nums, k,n);
        System.out.println(r1);

        //Approach 3 using  max Heap
        int[] nums1 = new int[]{3,2,3,1,2,4,5,5,6};
        int r2=usingMaxHeap(nums1, k ,n);
        System.out.println(r2);

        // Approach 3: Best Approach
        //Below is the best method
        //1) Create a min heap of size k
        //2) check if size of heap > k then pop
        //3) continue this till we have elements in array

        int r3=usingMinHeap(nums1, k , n);
        System.out.println(r3);
    }

    private static  int usingCustomHeap(int[] nums, int k ,int n){

        for(int i=n/2-1;i>=0;i--){
            heapifyTopToBottom(nums,n,i);
        }
       // TC:O(N) for build max heap

        int result=0;
        if(k>n)
            System.out.println("Not found");
        while(k>0){
            result=extractMax(nums,n);
            k--;
            --n;
        }
        return result;

        //TC:O(n/2) + O( K log N) since we insert all elements in max heap and then remove
        //SC:O(n)
    }

    private static int usingMaxHeap(int[] nums, int k, int n){

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int no:nums)
            pq.offer(no);

        if(k>n)
            System.out.println("Not found");
        Integer result=-1;

        while(k>0){
            result=pq.poll();
            k--;
        }
        return result;

        //TC:O(N) + O( K log N)
        //SC:O(n)
    }

    private static int usingMinHeap(int[] nums,int k, int n) {

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(Integer no:nums) {
            pq.offer(no);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();

        //TC:O(N log K)
        //SC:O(k)
    }

    public static void heapifyTopToBottom(int[] arr, int n, int i){

        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left < n && arr[left] > arr[largest])
            largest=left;
        if(right < n && arr[right] > arr[largest])
            largest=right;
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapifyTopToBottom(arr,n,largest);
        }
    }

    public static int extractMax(int[] nums, int n){

        int removed=nums[0];
        nums[0]=nums[--n];
        heapifyTopToBottom(nums, n,0);
        return removed;
    }
}