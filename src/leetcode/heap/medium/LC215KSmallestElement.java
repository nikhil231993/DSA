package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC215KSmallestElement {

    public static void main(String[] args) {

        int[] arr=new int[]{7, 10, 4, 20, 15};
        int n=arr.length;
        System.out.println(kthSmallest(arr, 0, 4, 4));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) {

        //Using max heap
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b - a);
        for(int n:arr){
            pq.offer(n);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();

        // TC:O(log n)
        // SC:O(K)
    }
}
