package leetcode.heap.medium;

import java.util.PriorityQueue;
public class LC2208HalfArray {

    public static void main(String[] args) {

        int[]  nums =new int[] {5,19,8,1};
        System.out.println(halveArray(nums));
    }

    public static int halveArray(int[] nums) {

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
}
