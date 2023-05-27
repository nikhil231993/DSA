package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP17CountSubsetsWithSumKWithZero {

    //if numbers range from 0 to n instead of 1 to n then find 2 raise to n
    // where n is the no of zeroes an multiply the result we have solved it in next

    public static void main(String[] args) {
        int[] nums=new int[]{0,0,1};
        int n=nums.length;
        int sum=1;

        //Recursion
        System.out.println(recursion(nums,n-1,sum));

        //Memoization
        int[][] dp=new int[n][sum+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(nums,n-1,sum,dp));
    }

    private static int memoization(int[] nums, int i, int sum, int[][] dp) {

        if(i==0){
            if(sum==0 && nums[i]==0) return 2;
            if(sum==0 || nums[i]==sum)
                return 1;
            return 0;
        }

        if(dp[i][sum]!=-1)
            return dp[i][sum];

        int np=memoization(nums,i-1,sum,dp);
        int p=0;
        if(nums[i]<=sum)
            p=memoization(nums,i-1,sum-nums[i],dp);
        return dp[i][sum]=np+p;
        //TC:O(N*Sum)
        //SC:O(N*sum) dp array +O(N)stack
    }

    private static int recursion(int[] nums, int i,int sum) {

        if(i==0){
            if(sum==0 && nums[i]==0) return 2;
            if(sum==0 || nums[i]==sum)
                return 1;
            return 0;
        }

        int np=recursion(nums,i-1,sum);
        int p=0;
        if(nums[i]<=sum)
            p=recursion(nums,i-1,sum-nums[i]);
        return np+p;
        //TC:o(2 raise to n)
        //Sc:o(n) recursion stack
    }
}
