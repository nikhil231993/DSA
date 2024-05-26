package leetcode.twopointer.striver;

import java.util.HashMap;

public class V9BinarySubarraySumLC930 {

    public static void main(String[] args) {

        int[] nums =new int[] {1,0,1,0,1};
        int  goal = 2;

        //Approach 1 : Brute will be to generate all solutions

        //Approach 2: Better
        System.out.println(numSubarraysWithSumUsingMap(nums, goal));

        //Approach 3: Best getting rid of space
        System.out.println(numSubarraysWithSum(nums, goal));

        //we cannot use "if" instead of "while" as in counting we will miss some subarrays. Take an example and try out
        //Finding Longest length we can use as its to find max length
    }

    private static int numSubarraysWithSum(int[] nums, int goal) {

        int atLeastGoal=numSubarraySum(nums, goal);
        int atLeastLessThanGoal=numSubarraySum(nums, goal-1);
        return atLeastGoal-atLeastLessThanGoal;

        //TC:O(2*2N)
        //SC:O(1)
    }

    private static int numSubarraySum(int[] nums, int goal) {

        if(goal<0)
            return 0;

        int right=0, left=0, count=0,n=nums.length, sum=0;
        while(right<n){
            sum+=nums[right];

            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            if(sum<=goal)
                count+=right-left+1;
            right++;
        }
        return count;
    }

    public static int numSubarraysWithSumUsingMap(int[] nums, int goal) {

        int count=0;

        HashMap<Integer, Integer> map=new HashMap<>();
        int n=nums.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
            if(sum==goal)
                count++;
            if(map.containsKey(sum-goal))
                count+=map.get(sum-goal);

            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
