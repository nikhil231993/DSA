package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP3FrogJump {

    public static void main(String[] args) {
        int[] height=new int[]{30,10,60,10,60,50};
        int n=6;

        //recursion
        System.out.println(recursion(n-1,height));
        //TC:O(2 raise to N)
        //SC:O(N) recursion stack

        //Memoization -->Top Down
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(memoization(n-1,height,dp));
        //TC:o(N)
        //SC:O(N) recursion stack + O(N)dp array


        //Tabulation -->Bottom Up
        //Step is the below
        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);
        System.out.println(tabulation(n,height,dp1));
        //TC:o(N)
        //SC: O(N)dp array

        //Space Optimization
        System.out.println(spaceOptimized(n,height));
        //TC:o(N)
        //SC: O(1)

    }

    private static int spaceOptimized(int n, int[] height) {

        int prev=0;
        int prev2=0;

        for(int i=1;i<n;i++){
            int left=prev+Math.abs(height[i]-height[i-1]);
            int right=Integer.MAX_VALUE;
            if(i>1)
                right=prev2+Math.abs(height[i]-height[i-2]);

            int curr=Math.min(left,right);

            prev2=prev;
            prev=curr;
        }
        return prev;
    }

    private static int tabulation(int n, int[] height, int[] dp) {
        //Step 2 is the base case
        dp[0]=0;

        //Step lines after the base case
        for(int i=1;i<n;i++){
            int left=dp[i-1]+Math.abs(height[i]-height[i-1]);
            int right=Integer.MAX_VALUE;
            if(i>1)
                right=dp[i-2]+Math.abs(height[i]-height[i-2]);

            dp[i]=Math.min(left,right);
        }
        return dp[n-1];//as it is 1 based indexing
    }

    private static int memoization(int n, int[] height,int[] dp) {

        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];
        int left=memoization(n-1,height,dp)+ Math.abs(height[n]-height[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1)
            right=memoization(n-2,height,dp)+Math.abs(height[n]-height[n-2]);
        return dp[n]=Math.min(left,right);
    }

    private static int recursion(int n,int[] height) {

        if(n==0)
            return 0;
        int left=recursion(n-1,height)+Math.abs(height[n]-height[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1){
            right=recursion(n-2,height)+Math.abs(height[n]-height[n-2]);
        }
        return Math.min(left,right);
    }
}
