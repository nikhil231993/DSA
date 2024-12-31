package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP17CountSubsetsWithSumK {

    //if numbers range from 0 to n instead of 1 to n then find 2 raise to n
    // where n is the no of zeroes an multiply the result we have solved it in next

    public static void main(String[] args) {

        int[] nums=new int[]{1,2,3,3};
        int n=nums.length;
        int sum=3;

        //Recursion
        System.out.println(recursion(nums,n-1,sum));

        //Memoization
        int[][] dp=new int[n][sum+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(nums,n-1,sum,dp));

        //Tabulation
        int[][] dp1=new int[n][sum+1];
        for(int[] r:dp1)
            Arrays.fill(r,0);
        System.out.println(tabulation(nums,n,sum,dp1));

        //Space
        System.out.println(space(nums,n,sum));
    }

    private static int space(int[] nums, int n, int K) {
        int[] prev=new int[K+1];
        int[] curr=new int[K+1];
           curr[0]=prev[0]=1;
           prev[nums[0]]=1;

        for(int i=1;i<n;i++){
            for(int sum=1;sum<=K;sum++){
                int np=prev[sum];
                int p=0;
                if(nums[i]<=sum)
                    p=prev[sum-nums[i]];
                curr[sum]=np+p;
            }
            prev=curr;
        }
        return prev[K];
        //TC:O(N*Sum)
        //SC:O(sum)
    }

    private static int tabulation(int[] nums, int n, int K, int[][] dp1) {

        for(int i=0;i<n;i++)
            dp1[i][0]=1;
        if(nums[0]<=K)
           dp1[0][nums[0]]=1;

        for(int i=1;i<n;i++){
            for(int sum=1;sum<=K;sum++){
                int np=dp1[i-1][sum];
                int p=0;
                if(nums[i]<=sum)
                    p=dp1[i-1][sum-nums[i]];
                dp1[i][sum]=np+p;
            }
        }
        return dp1[n-1][K];
        //TC:O(N*Sum)
        //SC:O(N*sum) dp array
    }

    private static int memoization(int[] nums, int i, int sum, int[][] dp) {

        if(sum==0)
            return 1;
        if(i==0){
            if(nums[i]==sum)
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

        if(sum==0)
            return 1;
        if(i==0){
            if(nums[i]==sum)
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
