package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP4FrogKJumps {

    public static void main(String[] args) {
        int[] height=new int[]{30,10,60,10,60,50};
        int n=6;
        int k=2;

        //recursion
        System.out.println(recursion(height,n-1,k));

        //Memoization
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(memoization(dp,height,n-1,k));
        //TC:O(N*K)
        //SC:O(N) recursion +O(N)array

        //Tabulation
        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);
        System.out.println(tabulation(dp1,height,n,k));
    }

    private static int tabulation(int[] dp1, int[] height, int n, int k) {

        dp1[0]=0;

        for(int m=1;m<n;m++){
            int min=Integer.MAX_VALUE;
           int jump=0;
            for(int i=1;i<=k;i++){
                if(m-i>=0) {
                    jump = dp1[m - i] + Math.abs(height[m] - height[m - i]);
                    min = Math.min(jump, min);
                }
            }
            dp1[m]=min;
        }
        return dp1[n-1];
    }

    private static int memoization(int[] dp, int[] height, int n, int k) {

        if(n==0)
            return 0;
        if(dp[n]!=-1)
            return dp[n];

        int min=Integer.MAX_VALUE;
        int jumps=0;
        for(int i=1;i<=k;i++){
            if(n-i>=0) {
                jumps = memoization(dp, height, n - i, k) + Math.abs(height[n] - height[n - i]);
                min = Math.min(min, jumps);
            }
        }
        return dp[n-1]=min;
    }

    private static int recursion(int[] height, int n, int k) {

        if(n==0)
            return 0;

        //for loop for k jumps
        int min=Integer.MAX_VALUE;
        int jumps=0;
        for(int i=1;i<=k;i++){
            if(n-i>=0) {
                jumps = recursion(height, n - i, k) + Math.abs(height[n] - height[n - i]);
                min = Math.min(min, jumps);
            }
        }
        return min;
    }
}
