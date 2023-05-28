package leetcode.dynamicprogramming;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class DP24RodCutting {

    public static void main(String[] args) {
        int price[] = {1,5,8,9,10,17,17,20};

        int n = 8;

        //Recursion
        System.out.println(recursion(n-1,price,n));

        //Memoization
        int[][] dp=new int[n][n+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(n-1,price,n,dp));

    }

    private static int memoization(int i, int[] price, int n, int[][] dp) {
        if(i==0){
            return n*price[i];
        }

        if(dp[i][n]!=-1)
            return dp[i][n];

        int np=0+recursion(i-1,price,n);
        int p=-(int)(1e9);
        int rodLength=i+1;
        if(rodLength<=n)
            p=price[i]+recursion(i,price,n-rodLength);

        return dp[i][n]=Math.max(p,np);

        //TC:O(N*m)
        //SC:O(N*m)dp array+O(N) stack i.e price N
    }

    private static int recursion(int i, int[] price,int n) {

        if(i==0){
            return n*price[i];
        }

        int np=0+recursion(i-1,price,n);
        int p=-(int)(1e9);
        int rodLength=i+1;
        if(rodLength<=n)
            p=price[i]+recursion(i,price,n-rodLength);

        return Math.max(p,np);

        //TC:>>O(N) exponential
        //SC:>>O(N) i.e price N
    }
}
