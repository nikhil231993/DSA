package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP23UnBoundedKnapsack {

    public static void main(String[] args) {

        int wt[] =new int[] {1, 3, 4, 5};
        int val[] =new int[] {6, 1, 7, 7};
        int W=8 ;

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

    private static int space(int n, int w, int[] wt, int[] val) {

        int[] prev=new int[w+1];
        for(int i=0;i<=w;i++)
            prev[i]=((int)i/wt[0])*val[0];

        for(int i=1;i<n;i++){
            int[] curr=new int[w+1];
            for(int tar=0;tar<=w;tar++){
                int notPick=0+prev[tar];

                int pick=-(int)10e9;
                if(wt[i]<=tar)
                    pick=val[i]+curr[tar-wt[i]];

                curr[tar]= Math.max(notPick,pick);
            }
            prev=curr;
        }
        return prev[w];
    }

    private static int tabulation(int n, int w, int[] wt, int[] val, int[][] dp1) {

        for(int i=0;i<=w;i++)
            dp1[0][i]=((int)i/wt[0])*val[0];

        for(int i=1;i<n;i++){
            for(int tar=0;tar<=w;tar++){
                int notPick=0+dp1[i-1][tar];

                int pick=-(int)10e9;
                if(wt[i]<=tar)
                    pick=val[i]+dp1[i][tar-wt[i]];

                dp1[i][tar]= Math.max(notPick,pick);
            }
        }
        return dp1[n-1][w];
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

        //TC:O(2 raise to N) or exponential
        //SC:O(N) recursion stack or O(weight)
    }
}
