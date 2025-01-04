package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP38LC188Stock4 {

    public static void main(String[] args) {

        int k = 2;
        int[] prices =new int[] {3,2,6,5,0,3};
        int n=prices.length;

        //Recursion
        System.out.println(recursion(n,prices,0,1,k));

        //Memoization
        int[][][] dp=new int[n][2][k+1];
        for(int[][] r: dp){
            for(int[] c:r)
                Arrays.fill(c,-1);
        }
        System.out.println(memoization(n,prices,0,1,k,dp));

        //Tabulation
        int[][][] dp1=new int[n+1][2][k+1];
        for(int[][] r: dp1){
            for(int[] c:r)
                Arrays.fill(c,0);
        }
        System.out.println(tabulation(n,prices,k,dp1));

        //Space
        System.out.println(space(n,prices,k));
    }

    private static int space(int n, int[] prices, int cap) {

        int[][] ahead=new int[2][cap+1];

        //we can ignore above two base cases if we initialize dp array to 0

        for(int index=n-1;index>=0;index--){
            int[][] curr=new int[2][cap+1];
            for(int buy=0;buy<=1;buy++){
                for(int c=1;c<=cap;c++){
                    int profit=Integer.MIN_VALUE;
                    if(buy==1){
                        profit=Math.max(-prices[index]+ahead[0][c],0+ahead[1][c]);
                    }else{
                        profit=Math.max(prices[index]+ahead[1][c-1], 0+ahead[0][c]);
                    }
                    curr[buy][c]=profit;
                }
            }
            ahead=curr;
        }
        return ahead[1][cap];

        //TC:O(N*2*k)
        //SC:O(N*2*k) dp array
    }

    private static int tabulation(int n, int[] prices, int cap,int[][][] dp1) {

        //1st base case when index==n
        for(int j=0;j<=1;j++){
            for(int k=0;k<=cap;k++){
                dp1[n][j][k]=0;
            }
        }

        //2nd  base case when cap==0
        for(int i=0;i<=n;i++){
            for(int j=0;j<=1;j++){
                dp1[i][j][0]=0;
            }
        }

        //we can ignore above two base cases if we initialize dp array to 0

        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<=1;buy++){
                for(int c=1;c<=cap;c++){
                    int profit=Integer.MIN_VALUE;
                    if(buy==1){
                        profit=Math.max(-prices[index]+dp1[index+1][0][c],0+dp1[index+1][1][c]);
                    }else{
                        profit=Math.max(prices[index]+dp1[index+1][1][c-1], 0+dp1[index+1][0][c]);
                    }
                    dp1[index][buy][c]=profit;
                }
            }
        }
        return dp1[0][1][cap];

        //TC:O(N*2*k)
        //SC:O(N*2*k) dp array
    }

    private static int memoization(int n, int[] prices, int index, int buy, int cap, int[][][] dp) {

        if(cap==0)
            return 0;
        if(index==n)
            return 0;
        if(dp[index][buy][cap]!=-1)
            return dp[index][buy][cap];

        int profit=Integer.MIN_VALUE;
        if(buy==1){
            profit=Math.max(-prices[index]+recursion(n,prices,index+1,0,cap),
                    0+recursion(n,prices,index+1,1,cap));
        }else{
            profit=Math.max(prices[index]+recursion(n,prices,index+1,1,cap-1),
                    0+recursion(n,prices,index+1,0,cap));
        }
        return dp[index][buy][cap]= profit;

        //TC:O(N*2*K)
        //SC:O(N)+O(N*2*k) dp array
    }

    private static int recursion(int n, int[] prices, int index, int buy, int cap) {

        if(cap==0)
            return 0;
        if(index==n)
            return 0;

        int profit=Integer.MIN_VALUE;
        if(buy==1){
            profit=Math.max(-prices[index]+recursion(n,prices,index+1,0,cap),0+recursion(n,prices,index+1,1,cap));
        }else{
            profit=Math.max(prices[index]+recursion(n,prices,index+1,1,cap-1),
                    0+recursion(n,prices,index+1,0,cap));
        }
        return profit;

        //TC:O(exponential)
        //SC:O(N)
    }
}
