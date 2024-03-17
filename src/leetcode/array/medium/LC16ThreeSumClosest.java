package leetcode.array.medium;

import java.util.Arrays;

public class LC16ThreeSumClosest {

    public static void main(String[] args) {

        int[] nums =new int[] {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);//O(nlogn)

        int diff=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<nums.length-2;i++){
            int first=nums[i];
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                if(first+nums[start]+nums[end]==target)
                    return target;
                if(Math.abs(first+nums[start]+nums[end]-target)<diff){
                    diff=Math.abs(first+nums[start]+nums[end]-target);
                    ans=first+nums[start]+nums[end];
                }
                if(first+nums[start]+nums[end]>target)
                    end--;
                else
                    start++;
            }
        }
        return ans;
        //TC:O(n2)
        //SC:O(1)
    }
}
