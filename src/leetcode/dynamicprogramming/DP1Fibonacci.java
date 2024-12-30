package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP1Fibonacci {

    public static void main(String[] args) {

        int n=4;

        //Recursion
        System.out.println(recursion(n));

        //Memoization method (top dow same as recursion)
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fibMemoization(dp,n));

        //Tabulation (Bottom up approach)
        int[] dp1=new int[n+1];
        Arrays.fill(dp1,-1);
        System.out.println(fibTabulation(n,dp1));

        //Space optimization
        System.out.println(fibSpaceOptimization(n));
    }

    private static int recursion(int n) {

        if(n<=1)
            return n;
        return recursion(n-1) + recursion(n-2);

        //TC:O(2 raise to N)
        //SC:O(N) recursion stack
    }

    private static int fibSpaceOptimization(int n) {

        if(n==0) return n;

        int prev2=0;
        int prev=1;

        for(int i=2; i<=n; i++){
            int curr=prev2+prev;
            prev2=prev;
            prev=curr;
        }
        return prev;

        //TC:O(N)
        //SC:O(1)
    }

    private static int fibTabulation(int n, int[] dp1) {

        if(n==0) return n;

        dp1[0]=0;
        dp1[1]=1;
        for(int i=2; i<=n; i++){
            dp1[i] = dp1[i-1] + dp1[i-2];
        }
        return dp1[n];

        //TC:O(N)
        //SC:O(N) dp array only
    }

    private static int fibMemoization(int[] dp, int n) {

        if(n<=1)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n] = fibMemoization(dp,n-1) + fibMemoization(dp,n-2);

        //TC:O(N) since it is linear, and we do not compute already computed value again
        //SC:O(N) recursion stack + O(N) dp array
    }
}
