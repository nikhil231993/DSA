package leetcode.dynamicprogramming;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class DP11LC120Traingle {

    public static void main(String[] args) {
        int[][] tri =new int[][] {{2},{3,4},{6,5,7},{4,1,8,3}};

        List<List<Integer>> triangle=new ArrayList<>();

        for(int i=0;i<tri.length;i++){
            triangle.add(new ArrayList<>());
        }
        int i=0;
        for(int[] r:tri){
            for(int c:r){
                triangle.get(i).add(c);
            }
            i++;
        }

        System.out.println(triangle);

        //Recursion
        System.out.println(minimumTotal(triangle));

        //Memoization
        System.out.println(minimumTotalMemouization(triangle));
        //TC:O(N)
        //SC:o(n*m) dp array +O(N) recursion stack

    }

    public  static int minimumTotalMemouization(List<List<Integer>> triangle) {

        int n=triangle.size();
        int m=triangle.get(n-1).size();

        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }

        return recursionMemoization(0,0,triangle,n,m,dp);

    }
    public static int recursionMemoization(int i, int j, List<List<Integer>> list, int n, int m,int[][] dp){
        if(i==n-1){
            return list.get(n-1).get(j);
        }

        if(dp[i][j]!=-1)
            return dp[i][j];

        int d=list.get(i).get(j)+recursionMemoization(i+1,j,list,n,m,dp);
        int diag=list.get(i).get(j)+recursionMemoization(i+1,j+1,list,n,m,dp);
        return dp[i][j]=Math.min(d,diag);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {

        int n=triangle.size();
        int m=triangle.get(n-1).size();

        return recursion(0,0,triangle,n,m);

    }
    public static int recursion(int i, int j, List<List<Integer>> list, int n, int m){
        if(i==n-1){
            return list.get(n-1).get(j);
        }

        int d=list.get(i).get(j)+recursion(i+1,j,list,n,m);
        int diag=list.get(i).get(j)+recursion(i+1,j+1,list,n,m);
        return Math.min(d,diag);
        //TC:O(2 raise to N)
        //SC:O(N)
    }
}
