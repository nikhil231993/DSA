package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

class Oranges{
    int row;
    int col;
    int level;
    public Oranges(int row,int col, int level){
        this.row=row;
        this.col=col;
        this.level=level;
    }
}
public class G10LC994RottingOranges {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        G10LC994RottingOranges g=new G10LC994RottingOranges();
        System.out.println(g.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        Queue<Oranges> q=new LinkedList();
        int freshOranges=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Oranges(i,j,0));
                    visited[i][j]=2;
                }

                if(grid[i][j]==1)
                    freshOranges++;
            }
        }
        int count=0;
        int max=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int lev=q.peek().level;
            q.poll();

            int[] x_axis=new int[]{1,0,-1,0};
            int[] y_axis=new int[]{0,-1,0,1};
            max=Math.max(max,lev);
            for(int i=0;i<4;i++){
                int nrow=x_axis[i]+row;
                int ncol=y_axis[i]+col;

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    count++;
                    visited[nrow][ncol]=2;
                    q.offer(new Oranges(nrow,ncol,lev+1));
                }
            }
        }

        if(count!=freshOranges) return -1;
        return max;
        //TC:(n*m) initila loop+o(n*m) if all oranges are fresh apart from 1st queue will run this time +O(m*n*4) for all nodes inside loop runs this time
        //SC:O(m*n) visited matrix +O(m*n) queue

    }
}
