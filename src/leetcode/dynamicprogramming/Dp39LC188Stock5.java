package leetcode.dynamicprogramming;

import java.util.Arrays;

public class Dp39LC188Stock5 {

    public static void main(String[] args) { // Video 1:13

        int[] prices =new int[] {1,2,3,0,2};
        int n=prices.length;

        //Recursion
        System.out.println(recursion(n,prices,0,1));

        //Memoization
        int[][] dp=new int[n][2];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(n,prices,0,1,dp));

        //Tabulation
        //Here we have n+2 because of sell case where we have index+2
        //also here dp should be 0 else it will add negative value as well
        int[][] dp1=new int[n+2][2];
        System.out.println(tabulation(n,prices,0,1,dp1));

        //Space
        //System.out.println(space(n,prices,0,1));
        //we cannot do space optimization as we would have to store 3 rows ahead because of n+2
    }

    private static int tabulation(int n, int[] prices, int index, int buy, int[][] dp1) {

        dp1[n][0]=0;
        dp1[n][1]=0;

        for(int i=n-1;i>=0;i--){
            for(int b=0;b<=1;b++){
                int profit=Integer.MIN_VALUE;
                if(b==1){
                    profit=Math.max(-prices[i]+dp1[i+1][0], 0+dp1[i+1][1]);
                }else {
                        profit=Math.max(prices[i]+dp1[i+2][1], 0+dp1[i+1][0]);
                }
                 dp1[i][b]=profit;
            }
        }
        return dp1[index][buy];
    }

    private static int memoization(int n, int[] prices, int index, int buy, int[][] dp) {

        if(index>=n)
            return 0;

        if(dp[index][buy]!=-1)
            return dp[n][buy];

        int profit=Integer.MIN_VALUE;
        if(buy==1){
            profit=Math.max((-prices[index]+recursion(n,prices,index+1,0)),
                    0+recursion(n,prices,index+1,1));
        }else {
            profit=Math.max((prices[index]+recursion(n,prices,index+2,1)),
                    0+recursion(n,prices,index+1,0));
        }
        return dp[index][buy]=profit;

        //TC:O(N*2)
        //SC:O(N) recursion stack+O(N*2) dp array
    }

    private static int recursion(int n, int[] prices, int index, int buy) {

        if(index>=n)
            return 0;
        int profit=Integer.MIN_VALUE;
        if(buy==1){
            profit=Math.max((-prices[index]+recursion(n,prices,index+1,0)),
                    0+recursion(n,prices,index+1,1));
        }else {
            profit=Math.max((prices[index]+recursion(n,prices,index+2,1)),
                    0+recursion(n,prices,index+1,0));
        }
        return profit;

        //TC:O(2 raise to N)
        //SC:O(N) recursion stack
    }
}
