package leetcode.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class L7ThirdCountAllSubsequenceWithSumK {

    public static void main(String[] args) {

        int[] nums=new int[]{1,2,3,4,5,6,7,8,9};
        int target=9;

        int result=subsequenceWithSumK(0, 0, target, nums, 0, nums.length);
        System.out.println("Count of Subsequences are: " + result);
    }

    private static int subsequenceWithSumK(int i, int sum, int target, int[] nums,int count, int n) {

        if(sum>target) return 0; //When we add this it passes TLE test case also but not in gfg as it is hard question there
        //above condition can be used only if it has positive numbers

        if(i==n){
            if(sum==target){
                return 1;
            }
            return 0;
        }

        int left=subsequenceWithSumK(i+1, sum+nums[i], target, nums, count, nums.length);
        int right=subsequenceWithSumK(i+1, sum, target, nums, count, nums.length);
        return left+right;
    }
}
