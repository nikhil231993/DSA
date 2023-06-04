package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP36LC122Stock2 {

    public static void main(String[] args) {
//        int[] prices =new int[] {7,1,5,3,6,4};
        int[] prices =new int[] {1,3,2,8,4,9};

        //Recursion
        System.out.println(recursion(prices,1,0));

        //Memoization
        int[][] dp=new int[prices.length][2];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(prices,1,0,dp));

        //Tabulation
        int n=prices.length;
        int[][] dp1=new int[n+1][2];
        for(int[] r:dp1)
            Arrays.fill(r,0);
        System.out.println(tabulation(prices,1,0,dp1,n));

        //Space
        System.out.println(space(prices,1,n));
    }

    private static int space(int[] prices, int buy, int n) {

        int[] ahead=new int[2];
        ahead[0]=0;
        ahead[1]=0;

        for(int ind=n-1;ind>=0;ind--){
            int[] curr=new int[2];
            for(int by=0;by<=1;by++){
                int profit=0;
                if(by==1){
                    profit=Math.max(-prices[ind]+ahead[0],0+ahead[1]);
                }else {
                    profit=Math.max(prices[ind]+ahead[1], 0+ahead[0]);
                }
                curr[by]=profit;
            }
            ahead=curr;
        }
        return ahead[buy];
    }

    private static int tabulation(int[] prices, int buy, int index, int[][] dp1,int n) {


        dp1[n][0]=0;
        dp1[n][1]=0;

        for(int ind=n-1;ind>=0;ind--){
            for(int by=0;by<=1;by++){
                int profit=0;
                if(by==1){
                    profit=Math.max(-prices[ind]+dp1[ind+1][0],0+dp1[ind+1][1]);
                }else {
                    profit=Math.max(prices[ind]+dp1[ind+1][1], 0+dp1[ind+1][0]);
                }
                 dp1[ind][by]=profit;
            }
        }
        return dp1[index][buy];
    }

    private static int memoization(int[] prices, int buy, int index, int[][] dp) {
        if(index==prices.length)
            return 0;

        if(dp[index][buy]!=-1)
            return dp[index][buy];

        int profit=0;
        if(buy==1){
            profit=Math.max((-prices[index]+memoization(prices,0,index+1,dp)),
                    0+memoization(prices,1,index+1,dp));
        }else {
            profit=Math.max((prices[index]+memoization(prices,1,index+1,dp)),
                    0+memoization(prices,0,index+1,dp));
        }
        return dp[index][buy]=profit;

        //buy ==1 means u can buy
        //TC:O(N*2)
        //SC:O(N .ie recursion stack)+O(index*buy)
    }

    private static int recursion(int[] prices, int buy,int index) {

        if(index==prices.length)
            return 0;

        int profit=0;
        if(buy==1){
            profit=Math.max((-prices[index]+recursion(prices,0,index+1)),
                    0+recursion(prices,1,index+1));
        }else {
            profit=Math.max((prices[index]+recursion(prices,1,index+1)),
                    0+recursion(prices,0,index+1));
        }
        return profit;

        //buy ==1 means u can buy
        //TC:O(2 raise to N)
        //SC:O(N) recursion stack
    }
}
