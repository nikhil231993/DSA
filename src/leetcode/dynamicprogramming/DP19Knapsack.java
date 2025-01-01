package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP19Knapsack {

    public static void main(String[] args) { // watch 11:03

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

        //Tabulation
        int[][] dp1=new int[n][W+1];
        System.out.println(tabulation(n,W,wt,val,dp1));

        //Space
        System.out.println(space(n,W,wt,val));
    }

    private static int space(int n, int wt, int[] weight, int[] value) {

        int[] prev=new int[wt+1];
        for(int w=weight[0];w<=wt;w++){
            if(weight[0]<=w)
                prev[w]=value[0];
        }

        for(int i=1;i<n;i++){
            int[] curr=new int[wt+1];
            for(int w=0;w<=wt;w++){
                int notpick=0+prev[w];
                int pick=-(int)(1e9);
                if(weight[i]<=w){
                    pick=value[i]+prev[w-weight[i]];
                }
                curr[w]=Math.max(notpick, pick);
            }
            prev=curr;
        }
        return prev[wt];

        //TC:O(N*W)
        //SC:O(W)
    }

    private static int tabulation(int n, int wt, int[] weight, int[] value, int[][] dp) {

        for(int w=weight[0];w<=wt;w++){
            if(weight[0]<=w)
                dp[0][w]=value[0];
        }

        for(int i=1;i<n;i++){
            for(int w=0;w<=wt;w++){
                int notpick=0+dp[i-1][w];
                int pick=-(int)(1e9);
                if(weight[i]<=w){
                    pick=value[i]+dp[i-1][w-weight[i]];
                }
                dp[i][w]=Math.max(notpick, pick);
            }
        }
        return dp[n-1][wt];

        //TC:O(N*W)
        //SC:O(n*w) dp array
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

        //TC:O(N*W)
        //SC:O(N) recursion stack + O(n*w) dp array
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
        //SC:O(N) recursion stack
    }
}
