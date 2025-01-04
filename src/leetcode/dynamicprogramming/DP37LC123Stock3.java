package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP37LC123Stock3 {

    public static void main(String[] args) {
        
        int[] prices =new int[] {3,3,5,0,0,3,1,4};
        int n=prices.length;

        //Recursion
        System.out.println(recursion(prices,n,1,2,0));

        //Memoization
        int[][][] dp=new int[n][2][3];
        for(int[][] r: dp){
            for(int[] c:r){
                Arrays.fill(c,-1);
            }
        }
        System.out.println(memoization(prices,n,1,2,0,dp));

        //Tabulation
        int[][][] dp1=new int[n+1][2][3];
        for(int[][] r: dp1){
            for(int[] c:r){
                Arrays.fill(c,0);
            }
        }
        System.out.println(tabulation(prices,n,dp1));

        //Space
        System.out.println(space(prices,n));
    }

    private static int space(int[] prices, int n) {

        int[][] ahead=new int[2][3];
        //we can ignore above two base cases if we initialize dp array to 0

        for(int index=n-1;index>=0;index--){
            int[][] curr=new int[2][3];
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    int profit=Integer.MIN_VALUE;
                    if(buy==1){
                        profit=Math.max(-prices[index]+ahead[0][cap],0+ahead[1][cap]);
                    }else{
                        profit=Math.max(prices[index]+ahead[1][cap-1], 0+ahead[0][cap]);
                    }
                   curr[buy][cap]=profit;
                }
            }
            ahead=curr;
        }
        return ahead[1][2];

        //TC:O(N*2*3)
        //SC:O(2*3) constant space
    }

    private static int tabulation(int[] prices, int n, int[][][] dp1) {

        //1st base case when index==n
        for(int j=0;j<=1;j++){
            for(int k=0;k<=2;k++){
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
                for(int cap=1;cap<=2;cap++){
                    int profit=Integer.MIN_VALUE;
                    if(buy==1){
                        profit=Math.max(-prices[index]+dp1[index+1][0][cap],0+dp1[index+1][1][cap]);
                    }else{
                        profit=Math.max(prices[index]+dp1[index+1][1][cap-1], 0+dp1[index+1][0][cap]);
                    }
                    dp1[index][buy][cap]=profit;
                }
            }
        }
        return dp1[0][1][2];

        //TC:o(N*2*3)
        //SC:O(N*2*3) dp array
    }

    private static int memoization(int[] prices, int n, int buy, int cap, int index, int[][][] dp) {

        if(cap==0)
            return 0;

        if(index==n)
            return 0;

        if(dp[index][buy][cap]!=-1)
            return dp[index][buy][cap];

        int profit=Integer.MIN_VALUE;
        if(buy==1){
            profit=Math.max(-prices[index]+recursion(prices,n,0,cap,index+1),
                    0+recursion(prices,n,1,cap,index+1));
        }else{
            profit=Math.max(prices[index]+recursion(prices,n,1,cap-1,index+1),
                    0+recursion(prices,n,0,cap,index+1));
        }
        return dp[index][buy][cap]=profit;

        //TC:O(N*2*3)
        //SC:O(N) stack+ O(N*2*3) dp array
    }

    private static int recursion(int[] prices, int n, int buy, int cap,int index) {
        if(cap==0)
            return 0;
        if(index==n)
            return 0;

        int profit=Integer.MIN_VALUE;
        if(buy==1){
            profit=Math.max(-prices[index]+recursion(prices,n,0,cap,index+1),
                    0+recursion(prices,n,1,cap,index+1));
        }else{
            profit=Math.max(prices[index]+recursion(prices,n,1,cap-1,index+1),
                    0+recursion(prices,n,0,cap,index+1));
        }
        return profit;

        //TC:O(exponential)
        //SC:O(N) stack
    }
}
