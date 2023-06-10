package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP51LC312BurstBalloons {

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        int n=nums.length;
        //we need to add 1 at start and end

        int[] numsNew=new int[n+2];
        numsNew[0]=1;
        for(int i=1;i<numsNew.length-1;i++)
            numsNew[i]=nums[i-1];
        numsNew[numsNew.length-1]=1;

        //Recursion
        System.out.println(recursion(1,n,numsNew));

        //Memoization
        int[][] dp=new int[n+1][n+1];
        for(int[] r:dp)
            Arrays.fill(r,-1);
        System.out.println(memoization(1,n,numsNew,dp));

        //Tabulation
        int[][] dp1=new int[n+2][n+2];
        System.out.println(tabulation(n,numsNew,dp1));

    }

    private static int tabulation(int n, int[] numsNew, int[][] dp1) {

        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int min=Integer.MIN_VALUE;
                int cost=0;
                for(int ind=i;ind<=j;ind++){

                    cost=numsNew[i-1]*numsNew[ind]*numsNew[j+1]+
                           dp1[i][ind-1]+dp1[ind+1][j];
                    min=Math.max(min,cost);
                }
                 dp1[i][j]=min;
            }
        }
        return dp1[1][n];
        //TC:O(Nsqaure)*N(for loop)
        //SC:O(N squre)
    }

    private static int memoization(int i, int j, int[] numsNew, int[][] dp) {

        if(i>j)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        int min=Integer.MIN_VALUE;
        int cost=0;
        for(int ind=i;ind<=j;ind++){
            cost=numsNew[i-1]*numsNew[ind]*numsNew[j+1]+
                    memoization(i,ind-1,numsNew,dp)+memoization(ind+1,j,numsNew,dp);
            min=Math.max(min,cost);
        }
        return dp[i][j]=min;
        //TC:O(exponential)
    }

    private static int recursion(int i, int j, int[] numsNew) {

        if(i>j)
            return 0;
        int min=Integer.MIN_VALUE;
        int cost=0;
        for(int ind=i;ind<=j;ind++){
            cost=numsNew[i-1]*numsNew[ind]*numsNew[j+1]+
                    recursion(i,ind-1,numsNew)+recursion(ind+1,j,numsNew);
            min=Math.max(min,cost);
        }
        return min;
        //TC:O(exponential)

    }
}
