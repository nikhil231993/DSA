package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC2530MaximalScore {

    public static void main(String[] args) {

       int[] nums =new int[] {10,10,10,10,10};
       //nums ={672579538,806947365,854095676,815137524}; k=3;
        // Since it fails for this output we use long in solution
       int k = 5;
       System.out.println(maxKelements(nums,k));

       // we can improve the nlog n of insertion by using either heapify as it is O(n) or we can put values in a list and use pq.addAll(list) this also takes O(n) TC
    }

    private static long maxKelements(int[] nums, int k) {

        PriorityQueue<Long> pq=new PriorityQueue<>((a, b)->Long.compare(b,a));
        for(int i=0;i<nums.length;i++){
            pq.offer((long)nums[i]);
        }

        long sum=0;
        while(k!=0){
            long num=pq.poll();
            sum+=num;
            long newNum=(int)Math.ceil(num/3.0);
            pq.offer(newNum);
            k--;
        }
        return sum;

        //TC:O(nlog n) for priority queue insertion + O(nlog k)
        //SC:O(n)
    }
}
