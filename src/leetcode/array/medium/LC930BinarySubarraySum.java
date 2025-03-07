package leetcode.array.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LC930BinarySubarraySum {

    public static void main(String[] args) {

        int[] nums = new int[]{1,0,1,0,1};
        int goal = 2;

        //Approach 1: Optimal Refer LC560 for brute force as both are same
        System.out.println(numSubarraysWithSum(nums, goal));

        //Approach 2: Optimal
        System.out.println(numSubarraysWithSumOptimal(nums, goal));
    }

    private static int numSubarraysWithSumOptimal(int[] nums, int goal) {

        int atLeastGoal=func(nums, goal);
        int atLeastLessThanGoal=func(nums, goal-1);
        return atLeastGoal-atLeastLessThanGoal;
    }

    private static int func(int[] nums, int goal) {

        int r=0, l=0, n=nums.length, count=0, sum=0;

        while(r<n){
            sum+=nums[r];

            while(sum>goal){
                sum-=nums[l];
                l++;
            }

            if(sum<=goal)
                count+=r-l+1;
            r++;
        }
        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {

        int sum=0;
        int count=0;
        HashMap<Integer,Integer> m=new LinkedHashMap<>();

        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(sum==goal){
                count++;
            }
            if (m.containsKey(sum - goal)) {
                count+=m.get(sum-goal);
            }
            m.put(sum,m.getOrDefault(sum,0) + 1);
        }
        return count;

        //TC:O(n)
        //SC:O(n)
    }
}
