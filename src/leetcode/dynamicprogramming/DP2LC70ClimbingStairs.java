package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP2LC70ClimbingStairs {

    public static void main(String[] args) {
        int n=3;

        //Recursion
        System.out.println(recursion(n));

        //memoization
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(climbStairsUsingMemoization(dp,n));
        //TC:O(N)
        //SC:O(N) recursion +O(N) dp array

        //Tabulation
        int[] dp1=new int[n+1];
        Arrays.fill(dp1,-1);
        System.out.println(climbStairsUsingTabulation(dp1,n));
        //TC:O(N)
        //SC:O(N) dp array

        //Space optimization
        System.out.println(climbStairsUsingSpaceOptimization(n));
        //TC:O(N)
        //SC:O(1)
    }

    private static int recursion(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        return recursion(n-1)+recursion(n-2);
        //TC:O(2 raise to N)
        //SC:O(N) recursion stack
    }

    private static int climbStairsUsingSpaceOptimization(int n) {
        int prev2=1;
        int prev1=1;
        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev1=prev2;
            prev2=curr;
        }
        return prev2;

    }

    private static int climbStairsUsingTabulation(int[] dp1, int n) {

        dp1[0]=1;
        dp1[1]=1;
        //dp[2]=2;
        //Above condition can be used when there are 1, 2 and 3 steps and below i will start from 3
        for(int i=2;i<=n;i++){
            dp1[i]=dp1[i-1]+dp1[i-2];
        }
        return dp1[n];
    }

    public static int climbStairsUsingMemoization(int[] dp, int n){
///        if(n<0)
///            return 0;
        //Above condition can be used when there are 1, 2 and 3 steps
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=climbStairsUsingMemoization(dp, n-1)+climbStairsUsingMemoization(dp, n-2);
                //+climbStairsUsingMemoization(dp,n-3);
    }
}
