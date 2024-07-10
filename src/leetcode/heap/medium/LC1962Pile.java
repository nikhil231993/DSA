package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC1962Pile {

    public static void main(String[] args) {

        int[] piles =new int[] {5,4,9};
        int k = 2;
        System.out.println(minStoneSum(piles,k));
    }

    public static int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        for(int i=0;i<piles.length;i++){
            pq.offer(piles[i]);
        }

        while(k!=0){
            Integer num=pq.poll();
            Integer newNum=(int)Math.ceil(num/2.0);
            pq.offer(newNum);
            k--;
        }
        int sum=0;
        while(!pq.isEmpty())
            sum+=pq.poll();

        return sum;

        //TC:O(n log n)
        //SC:O(n)
    }
}
