package leetcode.dynamicprogramming;

import leetcode.recursion.medium.LC50Pow;

import java.util.Arrays;

public class DP20LC320CoinChange {

    public static void main(String[] args) {

       int[] coins =new int[] {1,2,5};
       int amount = 11;

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
        for(int[] r:dp1)
            Arrays.fill(r,-1);
        System.out.println(tabulation(coins,amount,dp1,n));

        //space
        System.out.println(space(coins,amount,n));
    }

    private static int space(int[] coins, int amount, int n) {

        int[] prev=new int[amount+1];
        for(int t=0;t<=amount;t++)
            if(t%coins[0]==0)
                prev[t]=t/coins[0];
            else
                prev[t]=(int)(1e9);

        for(int i=1;i<n;i++){
            int[] curr=new int[amount+1];

            for(int target=0;target<=amount;target++){
                int np=0+prev[ target];
                int p=(int)1e9;
                if(coins[i]<=target)
                    p=1+curr[target-coins[i]];

               curr[target]=Math.min(np, p);
            }
            prev=curr;
        }
        return prev[amount];
    }

    private static int tabulation(int[] coins, int amount, int[][] dp1,int n) {

        for(int t=0;t<=amount;t++)
            if(t%coins[0]==0)
                dp1[0][t]=t/coins[0];
            else
                dp1[0][t]=(int)(1e9);

        for(int i=1;i<n;i++){
            for(int target=0;target<=amount;target++){

                int np=0+dp1[i-1][ target];
                int p=(int)1e9;
                if(coins[i]<=target)
                    p=1+dp1[i][target-coins[i]];

                dp1[i][target]=Math.min(np, p);
            }
        }
        return dp1[n-1][amount];
    }

    private static int memoization(int index,int[] coins, int amount, int[][] dp) {

        if(index==0){
            if(amount%coins[index]==0)
                return amount/coins[index];
            return (int)1e9;
        }
        if(dp[index][amount]!=-1)
            return dp[index][amount];

        int np=0+recursion(index-1, coins, amount);
        int p=(int)1e9;
        if(coins[index]<=amount)
            p=1+recursion(index, coins, amount-coins[index]);

        return dp[index][amount]=Math.min(np, p);

        //TC:O(N*amount)
        //SC:O(n*amount)+O(N) recursion
    }

    public static int coinChangeMemoization(int[] coins, int amount,int[][] dp) {

        int n=coins.length;
        int ans= memoization(n-1,coins, amount,dp);
        if(ans==(int)1e9)
            return -1;
        return ans;
    }

    public static int coinChange(int[] coins, int amount) {

        int n=coins.length;
        int ans= recursion(n-1,coins, amount);
        if(ans==(int)1e9)
            return -1;
        return ans;
    }

    public static int recursion(int index, int[] coins, int amount){

        if(index==0){
            if(amount%coins[index]==0)
                return amount/coins[index];
            return (int)1e9;
        }

        int np=0+recursion(index-1, coins, amount);
        int p=(int)1e9;
        if(coins[index]<=amount)
            p=1+recursion(index, coins, amount-coins[index]);

        return Math.min(np, p);

        //TC:>>O(2 raise N) or exponential
        //SC:>>O(N) .i.e O(target)
    }
}
