package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP41LC300LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums =new int[] {10,9,2,5,3,7,101,18};
        int n=nums.length;
        //Recursion
        System.out.println(recursion(n,nums,0,-1));

        //For Memoization we do a right shift for prevIndex as the prevIndex is -1 initially and we cannot
        //have such a case in dp

        int[][] dp=new int[n][n+1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(n,nums,0,-1,dp));
    }

    private static int memoization(int n, int[] nums, int index, int prevIndex, int[][] dp) {
        if(index==n)
            return 0;
        if(dp[index][prevIndex+1]!=-1)
            return dp[index][prevIndex+1];

        int np=0+memoization(n,nums,index+1,prevIndex,dp);
        int p=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex])
            p=1+memoization(n,nums,index+1,index,dp);
        return dp[index][prevIndex+1]=Math.max(np,p);
        //TC:O(N*N)
        //SC:O(N) recursion +O(N*N)
    }

    private static int recursion(int n, int[] nums, int index, int prevIndex) {
        if(index==n)
            return 0;

        int np=0+recursion(n,nums,index+1,prevIndex);//not pick so prevIndex remains same
        int p=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex])
            p=1+recursion(n,nums,index+1,index);//pick so prevIndex becomes current index
        return Math.max(np,p);
        //TC:O(2 raise to N)
        //SC:O(N)
    }
}
