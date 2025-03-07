package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP8LC62UniquePaths {

    public static void main(String[] args) {

        int m = 3, n = 7;

        //Recursion
        System.out.println(recursion(m-1,n-1));

        //Memoization
        int[][] dp=new int[m][n];
        for(int[] r: dp)
            Arrays.fill(r, -1);
        System.out.println(memoization(m-1,n-1,dp));

        //Tabulation
        int[][] dp1=new int[m][n];
        System.out.println(tabulation(m,n,dp1));

        //Space Optimization
        System.out.println(space(m,n));
    }

    private static int space(int m, int n) {

        int[] prev=new int[n];
        for(int i=0;i<m;i++) {
            int[] current=new int[n];
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0) current[j]=1;
                else{
                    int left=0,up=0;
                    if(i>0)
                        up =prev[j];
                    if(j>0)
                        left=current[j-1];
                    current[j]=up+left;
                }
            }
            prev=current;
        }
        return prev[n-1];

        //TC:O(m*n)
        //SC:O(n*m) dp arrays
    }

    private static int tabulation(int m, int n, int[][] dp) {

        dp[0][0]=1;
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0) dp[i][j]=1;
                else{
                    int left=0,up=0;
                    if(i>0)
                        up =dp[i-1][j];
                    if(j>0)
                        left=dp[i][j-1];
                    dp[i][j]=up+left;
                }
            }
        }
        return dp[m-1][n-1];

        //TC:O(m*n)
        //SC:O(n*m) dp arrays
    }

    private static int memoization(int m, int n, int[][] dp) {

        if(n==0 && m==0)
            return 1;

        if(m<0 || n<0)
            return 0;

        if(dp[m][n]!=-1)
            return dp[m][n];

        int up =memoization(m-1,n,dp);
        int left=memoization(m,n-1,dp);

        return dp[m][n]=up+left;

        //TC:O(m*n)
        //SC:O(path length) i.e.(n-1) + (m-1) + O(n*m) dp arrays
    }

    private static int recursion(int m, int n) {

            if(n==0 && m==0)
                 return 1;
             if(m<0 || n<0)
                 return 0;
             int up = recursion(m-1,n);
             int left = recursion(m,n-1);

             return up+left;

             //TC:O(2 raise to m*n) 14:56
             //SC:O(path length) i.e.(n-1) + (m-1)
    }
}
