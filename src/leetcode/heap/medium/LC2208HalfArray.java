package leetcode.heap.medium;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class LC2208HalfArray {

    public static void main(String[] args) {

        int[]  nums = new int[] {5,19,8,1};
        System.out.println(halveArray(nums));

        // we can improve the nlog n of insertion by using either heapify as it is O(n) or we can put values in a list and use pq.addAll(list) this also takes O(n) TC
    }

    private static int halveArray(int[] nums) {

        PriorityQueue<Double> pq=new PriorityQueue<>((a, b)->Double.compare(b,a));
        double sum=0.0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            pq.offer((double)nums[i]);
        }
        int count=0;
        double newSum=sum;
        while(!pq.isEmpty()){
            count++;
            double num=pq.poll();
            newSum-=num;
            double newNum=num/2;
            newSum+=newNum;
            pq.offer(newNum);
            if(newSum<=(sum/2.0))
                return count;
        }
        return 0;

        //TC:O(n log n)
        //SC:O(n)
    }

    private int halveArraySelf(int[] nums) {
        PriorityQueue<Double> pq=new PriorityQueue<>((a, b)->Double.compare(b,a));
        List<Double> list=new ArrayList<>();
        double sum=0.0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            list.add((double)nums[i]);
        }
        pq.addAll(list);
        int count=0;
        double newSum=sum;
        while(!pq.isEmpty()){
            count++;
            double num=pq.poll();
            newSum-=num;
            double newNum=num/2;
            newSum+=newNum;
            pq.offer(newNum);
            if(newSum<=(sum/2.0))
                return count;
        }
        return 0;
    }
}
