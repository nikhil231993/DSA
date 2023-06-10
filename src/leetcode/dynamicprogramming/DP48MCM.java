package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP48MCM {

    public static void main(String[] args) {
        int[] nums=new int[]{10, 20, 30, 40, 50};
        int n=nums.length;

        //Recursion
        System.out.println(recursion(1,n-1,nums));

        //Memoization
        int[][] dp=new int[n][n];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(1,n-1,nums, dp));
    }

    private static int memoization(int i, int j, int[] nums,int[][] dp) {
        if(i==j)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        int steps=(int)1e9;
        int min=0;
        for(int k=i;k<j;k++){
            steps=nums[i-1]*nums[k]*nums[j]+memoization(i,k,nums,dp)+memoization(k+1,j,nums,dp);
            min=Math.min(min,steps);
        }
        return dp[i][j]=steps;
        //TC:o(exponential)
    }

    private static int recursion(int i, int j, int[] nums) {

        if(i==j)
            return 0;
        int steps=(int)1e9;
        int min=0;
        for(int k=i;k<j;k++){
            steps=nums[i-1]*nums[k]*nums[j]+recursion(i,k,nums)+recursion(k+1,j,nums);
            min=Math.min(min,steps);
        }
        return steps;
        //TC:o(exponential)
    }
}
