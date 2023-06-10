package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP50LC1547MinimuCostCutStick {

    public static void main(String[] args) {
        int[] cuts =new int[] {3,5,1,4};
        int c = cuts.length;
        int n = 7;//Total length of array

        int[] cutsNew =new int[c+2];
        cutsNew[0]=0;
        for(int i=1;i<cutsNew.length-1;i++)
            cutsNew[i]=cuts[i-1];
        cutsNew[cutsNew.length-1]=7;

        Arrays.sort(cutsNew);

        //Recursion
        System.out.println(recursion(1,c,cutsNew));

        //Memoization
        //Since we include the cut also we have m+1
        int[][] dp=new int[c+1][c+1];
        for(int[] r: dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(1,c,cutsNew,dp));

        //Tabulation
        int[][] dp1=new int[c+2][c+2];
        System.out.println(tabulation(c,cutsNew,dp1));
    }

    private static int tabulation(int c, int[] cutsNew, int[][] dp) {

        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int cost=Integer.MAX_VALUE;
                for(int ind=i;ind<=j;ind++){
                    cost=Math.min(cost,cutsNew[j+1]-cutsNew[i-1]+
                            dp[i][ind-1]+dp[ind+1][j]);
                }
                dp[i][j]=cost;
            }
        }
        return dp[1][c];
        //TC:O(Nsqaure)*N(for loop)
        //SC:O(N squre)
    }

    private static int memoization(int i, int j, int[] cutsNew, int[][] dp) {

        if(i>j)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];
        int cost=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++){
            cost=Math.min(cost,cutsNew[j+1]-cutsNew[i-1]+memoization(i,ind-1,cutsNew,dp)+memoization(ind+1,j,cutsNew,dp));
        }
        return dp[i][j]=cost;

        //TC:O(Nsqaure)*N(for loop)
        //SC:O(N squre)+ stack space
    }

    private static int recursion(int i, int j, int[] cutsNew) {

        if(i>j)
            return 0;
        int cost=Integer.MAX_VALUE;

        for(int ind=i;ind<=j;ind++){
            cost=Math.min(cost,cutsNew[j+1]-cutsNew[i-1]+recursion(i,ind-1,cutsNew)+recursion(ind+1,j,cutsNew));
        }
        return cost;
    }
}
