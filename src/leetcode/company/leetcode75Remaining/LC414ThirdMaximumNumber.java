package leetcode.company.leetcode75Remaining;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC414ThirdMaximumNumber {

    public static void main(String[] args) {
       int[]  nums = new int[] {3,2,1};
        System.out.println(thirdMax(nums));

        //Best Approach is using 3 pointers. Ans in editorial
    }

    private static int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
                pq.offer(num);
            }

            if(pq.size()>3){
                int removed=pq.poll();
                set.remove(removed);
            }
        }
        if(pq.size()!=3){

            while(pq.size()>1)
                pq.poll();
        }
        return pq.poll();
    }
}
