package leetcode.company.microsoft;

import java.util.Arrays;

public class LC377CombinationSum4 {

    public static void main(String[] args) {
       int[] nums = new int[] {1,2,3};
       int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    private static int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int[][] dp=new int[n][target+1];
        for(int[] r: dp)
            Arrays.fill(r, -1);
        return recursion(0, nums, target, n, dp);
    }

    private static int recursion(int i, int[] nums, int target, int n, int[][] dp){
        if(i==n){
            if(target==0)
                return 1;
            return 0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int p=0;
        if(target>=nums[i])
            p=recursion(0, nums, target-nums[i], n, dp);
        int np=recursion(i+1, nums, target, n, dp);
        return dp[i][target]=p+np;
    }
}
