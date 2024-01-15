package leetcode.recursion.medium;

import java.util.ArrayList;

public class RatInMaze {

    public static void main(String[] args) {

        int N = 4;
        int m[][] =new int[][] {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};

        System.out.println(findPath(m,N));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] visited=new int[n][n];
        ArrayList<String> ans=new ArrayList<>();
        if(m[0][0]==0){
            ans.add("-1");
            return ans;
        }

        solve(0,0,visited, ans,n,m,"");
        return ans;
        //TC:O(4 raise to m*n)
        //SC:O(m*n) going through each element
    }

    public static void solve(int row, int col, int[][] visited, ArrayList<String> ans,int n,int[][] m ,String path){
        if(row==n-1 && col ==n-1) {
            ans.add(path);
            return;
        }
        int[] xaxis=new int[]{1,0,0,-1};
        int[] yaxis=new int[]{0,-1,1,0};
        String directions="DLRU";

        for(int k=0;k<4;k++){
            int nrow=row+xaxis[k];
            int ncol=col+yaxis[k];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<n && visited[nrow][ncol]!=1 && m[nrow][ncol]==1){
                visited[row][col]=1;
                solve(nrow,ncol,visited, ans,n,m,path+directions.charAt(k));
                visited[row][col]=0;
            }
        }
    }
}
