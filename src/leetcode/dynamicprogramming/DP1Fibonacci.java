package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP1Fibonacci {
    public static void main(String[] args) {
        int n=4;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        //Memoization method (top dow same as recursion)
        System.out.println(fib(dp,n));

        //Tabulation (Bottom up approach)
        int[] dp1=new int[n+1];
        Arrays.fill(dp1,-1);
        System.out.println(fibTabulation(n,dp1));

        //Space optimization
        System.out.println(fibSpaceOptimization(n));
        //TC:O(N)
        //SC:O(1 )

    }

    private static int fibSpaceOptimization(int n) {

        int f1=0;
        int f2=1;
        for(int i=2;i<=n;i++){
            int curr=f1+f2;
            f1=f2;
            f2=curr;
        }
        return f2;
    }

    private static int fibTabulation(int n, int[] dp1) {

        dp1[0]=0;
        dp1[1]=1;
        for(int i=2;i<=n;i++){
            dp1[i]=dp1[i-1]+dp1[i-2];
        }
        return dp1[n];
        //TC:O(N)
        //TC:O(N) dp array only
    }

    private static int fib(int[] dp, int n) {
        if(n<=1)
            return n;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=fib(dp,n-1)+fib(dp,n-2);
        //TC:O(N) since it is linear and we do not compute it each time
        //SC:O(N) recursion stack+ O(N) dp array
    }
}
