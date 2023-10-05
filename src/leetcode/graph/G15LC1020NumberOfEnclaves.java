package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;
class PairLC1020{
    int row;
    int col;
    public PairLC1020(int row,int col){
        this.row=row;
        this.col=col;
    }
}
public class G15LC1020NumberOfEnclaves {
    public static void main(String[] args) {

        int[][] grid = new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));

    }
    public static  int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
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
        //TC:O(n^2) upper for loop +O(n^2*4) while loop in case all elements are 1
        //SC:O(n^2) visited+O(n^2) queue
    }
}
