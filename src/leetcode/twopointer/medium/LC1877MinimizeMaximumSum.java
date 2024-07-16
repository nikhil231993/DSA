package leetcode.twopointer.medium;

import java.util.Arrays;

public class LC1877MinimizeMaximumSum {

    public static void main(String[] args) {

       int[] nums =new int[] {3,5,2,3};
       System.out.println(minPairSum(nums));
    }

    public static int minPairSum(int[] nums) {

        Arrays.sort(nums);
        int left=0, right=nums.length-1, max=Integer.MIN_VALUE;

        while(left<right){
            max=Math.max(max, nums[right--]+nums[left++]);
        }
        return max;

        //TC:O(nlogn)
        //SC:O(1)
    }
}
