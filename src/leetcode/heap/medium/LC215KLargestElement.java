package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC215KLargestElement {
    public static void main(String[] args) {
        //Approach 1 : Using custom heap sort

        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        int k = 4;
        int n=nums.length;
//        for(int i=n/2-1;i>=0;i--){
//            heapify(nums,n,i);
//        }
        //TC:O(N)
//        int result=0;
//        if(k>n)
//            System.out.println("Not found");
//        while(k>0){
//            result=extractMax(nums,n);
//            k--;
//            --n;
//        }
        //TC:O(KlogN)
//        System.out.println(result);

        //so TC:O(N)+O(KlogN)

        //Approach 2
//        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
//        for(int no:nums)
//            pq.offer(no);
//
//        if(k>n)
//            System.out.println("Nout found");
//        Integer result=-1;
//        while(k>0){
//            result=pq.poll();
//            k--;
//        }
//        System.out.println(result);

        //TC:O(N)+O(KlogN)

        // Approach 3
        //Below is the best method
        //1) Create a min heap of size k
        //2)check if size of heap > k then pop
        //3) continue this till we have elements in array

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(Integer no:nums)
        {
            pq.offer(no);
            if(pq.size()>k)
                pq.poll();
        }
        System.out.println(pq.poll());
    }

    public static void heapify(int[] arr, int n,int i){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left< n && arr[left]>arr[largest])
            largest=left;
        if(right<n && arr[right]>arr[largest])
            largest=right;
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapify(arr,n,largest);
        }
    }

    public static int extractMax(int[] nums, int n){
        int removed=nums[0];
        nums[0]=nums[--n];
        heapify(nums, n,0);
        return removed;
    }
}
