package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP23UnBoundedKnapsack {

    public static void main(String[] args) {
        int wt[] =new int[] {2,4,6};
        int val[] =new int[] {5,11,13};
        int W=10;

        //Recursion
        int n=wt.length;
        System.out.println(recursion(n-1,W,wt,val));

        //Memoization
        int[][] dp=new int[n][W+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(n-1,W,wt,val,dp));
    }

    private static int memoization(int i, int w, int[] wt, int[] val, int[][] dp) {
        if(i==0){
            return ((w/wt[i])*val[i]);
        }

        if(dp[i][w]!=-1)
            return dp[i][w];

        int notPick=0+recursion(i-1,w,wt,val);

        int pick=-(int)(1e9);
        if(wt[i]<=w)
            pick=val[i]+recursion(i,w-wt[i],wt,val);

        return dp[i][w]= Math.max(notPick,pick);

        //TC:O(N)
        //SC:o(N) recursion stack +O(n*w) dp array
    }

    private static int recursion(int i, int w, int[] wt, int[] val) {

        if(i==0){
            return ((w/wt[i])*val[i]);
        }

        int notPick=0+recursion(i-1,w,wt,val);

        int pick=-(int)(1e9);
        if(wt[i]<=w)
            pick=val[i]+recursion(i,w-wt[i],wt,val);

        return Math.max(notPick,pick);

        //TC:>>O(2 raise to N) or exponential
        //SC:>>o(N) recursion stack or O(weight)
    }
}
