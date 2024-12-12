package leetcode.array.medium;

import java.util.PriorityQueue;

public class LC1833IceCreamBars {

    public static void main(String[] args) {

        int[] costs =new int[] {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs,coins));
    }

    public static int maxIceCream(int[] costs, int coins) {

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int c : costs){
            pq.offer(c);
        }
        int count=0;
        while(!pq.isEmpty()){
            if(pq.peek()<=coins){
                count++;
                coins-=pq.peek();
                pq.poll();
            }else
                break;
        }
        return count;
    }
}
