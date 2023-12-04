package leetcode.TwoPointer.medium;

import java.util.Arrays;

public class LC1679MaxNumberOfKSumPairs {

    public static void main(String[] args) {
        int[] nums =new int[] {1,2,3,4};
        int k = 5;
        System.out.println(maxOperations(nums,k));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int count=0;
        while(left<right){
            if(nums[left]+nums[right]>k)
                right--;
            else if(nums[left]+nums[right]<k)
                left++;
            else{
                count++;
                left++;
                right--;
            }
        }
        return count;
    }
}
