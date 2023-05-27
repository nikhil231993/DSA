package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP13LC1493CherryPick2 {

    public static void main(String[] args) {
      int[][]  grid =new int[][] {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};

      //Recursion
        System.out.println(cherryPickup(grid));

        //Memoization
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];

        for(int[][] row1:dp){
            for(int[] row2:row1){
                Arrays.fill(row2,-1);
            }
        }
        System.out.println(memoization(0,0,m-1,grid,n,m,dp));
    }

    public static int memoization(int i, int j1, int j2, int[][] grid,int n, int m,int[][][] dp){
        if(i<0|| j1<0 || j2<0 || j1>= m || j2>=m)
            return -(int)1e9;
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }

        if(dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];

        int max=Integer.MIN_VALUE;
        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1; dj2<=1; dj2++){
                int ans=0;
                if(j1==j2){
                    ans=grid[i][j1]+memoization(i+1,j1+dj1,j2+dj2,grid,n,m,dp);
                }else{
                    ans=grid[i][j1]+grid[i][j2]+memoization(i+1,j1+dj1,j2+dj2,grid,n,m,dp);
                }
                max=Math.max(max,ans);
            }
        }
        return dp[i][j1][j2]= max;

        //TC:O(n*m*m)
        //SC:O(n)+O(n*m*m)
    }

    public static int cherryPickup(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        return recursion(0,0,m-1,grid,n,m);

    }

    public static int recursion(int i, int j1, int j2, int[][] grid,int n, int m){
        if(i<0|| j1<0 || j2<0 || j1>= m || j2>=m)
            return -(int)1e9;
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        int max=Integer.MIN_VALUE;
        for(int dj1=-1; dj1<=1; dj1++){
            for(int dj2=-1; dj2<=1; dj2++){
                int ans=0;
                if(j1==j2){
                    ans=grid[i][j1]+recursion(i+1,j1+dj1,j2+dj2,grid,n,m);
                }else{
                    ans=grid[i][j1]+grid[i][j2]+recursion(i+1,j1+dj1,j2+dj2,grid,n,m);
                }
                max=Math.max(max,ans);
            }
        }
        return max;

        //TC:O(3 raise to N * 3 raise to N)
        //SC:o(N)
    }
}
