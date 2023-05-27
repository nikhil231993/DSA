package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP19Knapsack {

    public static void main(String[] args) {
        int wt[] =new int[] {1,2,4,5};
        int val[] =new int[] {5,4,8,6};
        int W=6;

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
            if(wt[i]<=w)
                return val[i];
            return 0;
        }

        if(dp[i][w]!=-1)
            return dp[i][w];

        int notPick=0+recursion(i-1,w,wt,val);

        int pick=-(int)(1e9);
        if(wt[i]<=w)
            pick=val[i]+recursion(i-1,w-wt[i],wt,val);

        return dp[i][w]= Math.max(notPick,pick);

        //TC:O(N)
        //SC:o(N) recursion stack +O(n*w) dp array
    }

    private static int recursion(int i, int w, int[] wt, int[] val) {

        if(i==0){
            if(wt[i]<=w)
                return val[i];
            return 0;
        }

        int notPick=0+recursion(i-1,w,wt,val);

        int pick=-(int)(1e9);
        if(wt[i]<=w)
            pick=val[i]+recursion(i-1,w-wt[i],wt,val);

        return Math.max(notPick,pick);

        //TC:O(2 raise to N)
        //SC:o(N) recursion stack
    }
}
