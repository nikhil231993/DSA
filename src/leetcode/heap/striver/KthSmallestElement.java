package leetcode.heap.striver;

import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        int arr[] = new int[] {1, 2, 6, 4, 5, 3};
        int k=3;

        //Approach 1: Sort the array and find based on index
        //TC:O(nlogn)
        //SC:O(1)

        int result=kSmallest(arr,k);
        System.out.println(result);
    }

    public static int kSmallest(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b - a);
        for(int n:arr){
            pq.offer(n);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();

        //TC:O(k+(n-k)log k)
        //SC:O(k)
    }
}
