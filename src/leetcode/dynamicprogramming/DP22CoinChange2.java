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

        //Tabulation
        int[][] dp1=new int[n][amount+1];
        System.out.println(tabulation(coins,amount,dp1,n));

        //space
        System.out.println(space(coins,amount,n));
    }

    private static int space(int[] coins, int amount, int n) {

        int[] prev=new int[amount+1];
        for(int t=0;t<=amount;t++){
            if(t%coins[0]==0)
                prev[t]=1;
        }

        for(int i=1;i<n;i++){
            int[] curr=new int[amount+1];
            for(int target=0;target<=amount;target++){

                int np=prev[ target];
                int p=0;
                if(coins[i]<=target)
                    p=curr[target-coins[i]];

                curr[target]=np+p;
            }
            prev=curr;
        }
        return prev[amount];

        //TC:O(N*amount)
        //SC:O(amount)
    }

    private static int tabulation(int[] coins, int amount, int[][] dp1,int n) {

        for(int t=0; t<=amount; t++){
            if(t%coins[0]==0)
                dp1[0][t]=1;
        }

        for(int i=1;i<n;i++){
            for(int target=0;target<=amount;target++){

                int np=dp1[i-1][ target];
                int p=0;
                if(coins[i]<=target)
                    p=dp1[i][target-coins[i]];

                dp1[i][target]=np+p;
            }
        }
        return dp1[n-1][amount];

        //TC:O(N*amount)
        //SC:O(n*amount)
    }

    private static int memoization(int index,int[] coins, int amount, int[][] dp) {

        if(index==0){
            if(amount%coins[index]==0)
                return 1;
            return 0;
        }
        if(dp[index][amount]!=-1)
            return dp[index][amount];
        int np=recursion(index-1, coins, amount);
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
