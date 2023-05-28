package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP22CoinChange2 {

    public static void main(String[] args) {
        int[] coins =new int[] {1,2,5};
        int amount = 5;

        //Recursion
        System.out.println(coinChange(coins,amount));

        //Memoization
        int n= coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(coinChangeMemoization(coins,amount,dp));
    }

    private static int memoization(int index,int[] coins, int amount, int[][] dp) {

        if(index==0){
            if(amount%coins[index]==0)
                return 1;
            return 0;
        }
        if(dp[index][amount]!=-1)
            return dp[index][amount];


        int np=0+recursion(index-1, coins, amount);
        int p=0;
        if(coins[index]<=amount)
            p=recursion(index, coins, amount-coins[index]);

        return dp[index][amount]=np+ p;
        //TC:O(N*amount)
        //SC:O(n*amount)+O(N) recursion
    }

    public static int coinChangeMemoization(int[] coins, int amount,int[][] dp) {

        int n=coins.length;
        return memoization(n-1,coins, amount,dp);

    }

    public static int coinChange(int[] coins, int amount) {

        int n=coins.length;
        return recursion(n-1,coins, amount);
    }

    public static int recursion(int index, int[] coins, int amount){

        if(index==0){
            if(amount%coins[index]==0)
                return 1;
            return 0;
        }


        int np=0+recursion(index-1, coins, amount);
        int p=0;
        if(coins[index]<=amount)
            p=recursion(index, coins, amount-coins[index]);

        return p+np;

        //TC:>>O(2 raise to N) or exponential
        //SC:>>O(N) i.e O(amount) which is no of combinations
    }
}
