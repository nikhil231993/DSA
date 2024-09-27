package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

class PairLC1020{

    protected int row;
    protected int col;

    public PairLC1020(int row,int col){
        this.row=row;
        this.col=col;
    }
}

public class G15LC1020NumberOfEnclaves {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};

        System.out.println(numEnclaves(grid));
        System.out.println(numEnclavesDfs(grid));
    }

    private static int numEnclavesDfs(int[][] grid) {

        int nc=grid[0].length;
        int nr=grid.length;

        int[][] visited=new int[nr][nc];
        for(int c=0;c<nc;c++){

            if(visited[0][c]==0 && grid[0][c]==1)
                dfs(0,c,visited,grid);
            if(visited[nr-1][c]==0 && grid[nr-1][c]==1)
                dfs(nr-1,c,visited,grid);
        }

        for(int r=0;r<nr;r++){
            if(visited[r][0]==0 && grid[r][0]==1)
                dfs(r,0,visited,grid);
            if(visited[nc-1][0]==0 && grid[nc-1][0]==1)
                dfs(nc-1,0,visited,grid);
        }

        int count=0;
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                if(visited[i][j]==0 && grid[i][j]==1)
                    count++;
            }
        }
        return count;
    }

    private static void dfs(int r, int c, int[][] visited, int[][] grid) {

        visited[r][c]=1;

        int[] xrow=new int[]{0,1,0,-1};
        int[] ycol=new int[]{1,0,-1,0};

        for(int i=0;i<xrow.length;i++){
            int nrow=r+xrow[i];
            int ncol=c+ycol[i];

            if( nrow>=0 && nrow<grid.length && ncol>=0 && ncol <grid[0].length && visited[nrow][ncol]==0 && grid[nrow][ncol]==1)
                dfs(nrow,ncol, visited,grid);
        }
    }

    public static  int numEnclaves(int[][] grid) {

        int n=grid.length, m=grid[0].length;
        int[][] visited=new int[n][m];

        int[] xaxis=new int[] {1,0,-1,0};
        int[] yaxis=new int[] {0,-1,0,1};

        Queue<PairLC1020> q=new LinkedList();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0||i==n-1||j==m-1){
                    if(grid[i][j]==1){
                        visited[i][j]=1;
                        q.offer(new PairLC1020(i,j));
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            q.poll();

            for(int k=0;k<4;k++){
                int nrow=row+xaxis[k];
                int ncol=col+yaxis[k];

                if(nrow>=0 && nrow<n && ncol >=0 && ncol<m && grid[nrow][ncol]==1 && visited[nrow][ncol]==0){
                    visited[nrow][ncol]=1;
                    q.offer(new PairLC1020(nrow,ncol));
                }
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;

        //TC:O(n^2) upper for loop + O(n^2*4) while loop in case all elements are 1
        //SC:O(n^2) visited+O(n^2) queue
    }
}
