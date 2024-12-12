package leetcode.heap.easy;

import java.util.PriorityQueue;

public class GfgMinimumCostOfRopes {

    public static void main(String[] args) {

        int[] arr=new int[]{4,3,2,6};
        int n=4;
        System.out.println(minCost(arr,n));
}

    public static int minCost(int arr[], int n) {

        PriorityQueue<Integer> pq=new PriorityQueue();
        for(Integer num:arr)
            pq.offer(num);

        Integer cost=0;
        while(pq.size()!=1){
            Integer a=pq.poll();
            Integer b=pq.poll();
            cost+=a+b;
            pq.offer(a+b);
        }
        return cost;

        //TC:O(n log n)
        //SC:O(n)
    }
}
