package leetcode.heap.easy;

import java.util.PriorityQueue;

class Node3 {

    protected int diff;
    protected int value;

    public Node3(int diff, int value){
        this.diff=diff;
        this.value=value;
    }
}

public class LC2239FindClosestNumberToZero {

    public static void main(String[] args) {

       int[] nums =new int[] {-4,-2,1,4,8};

        //Approach 1
        System.out.println(findClosestNumber(nums));

        //Approach 2
        System.out.println(findClosestNumberHeap(nums));
    }

    public static int findClosestNumber(int[] nums) {

        Integer min=Integer.MAX_VALUE;

        int n=Integer.MIN_VALUE;;
        for(int num:nums)
            if(Math.abs(num-0)<min){
                min=Math.abs(num-0); //Math.abs(num)
                n=num;
            }else if(Math.abs(num-0)==min && num>n){
                min=Math.abs(num-0); //Math.abs(num)
                n=num;
            }
        return n;

        // TC:O(n)
        // SC:O(1)
    }
    
    public static int findClosestNumberHeap(int[] nums) {

        PriorityQueue<Node3> pq=new PriorityQueue<>((a,b)->
            a.diff == b.diff? a.value - b.value : b.diff - a.diff
        );
        for(int n: nums){
            pq.offer(new Node3(Math.abs(n-0), n));
            if(pq.size()>1){
                pq.poll();
            }
        }
        return pq.peek().value;
    }
}
