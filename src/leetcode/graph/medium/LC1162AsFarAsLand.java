package leetcode.graph.medium;

import java.util.LinkedList;
import java.util.Queue;
class Pair1162{
    int row;
    int col;
    int dist;
    public Pair1162(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
public class LC1162AsFarAsLand {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,1},{0,0,0},{1,0,1}};

        System.out.println(maxDistance(grid));
    }

    public static int maxDistance(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        Queue<Pair1162> q=new LinkedList();

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    visited[i][j]=1;
                    count++;
                    q.offer(new Pair1162(i,j,0));
                }
            }
        }

        if(q.isEmpty() || count ==n*m)
            return -1;

        int[] xaxis=new int[]{1,0,-1,0};
        int[] yaxis=new int[]{0,-1,0,1};
        int max=-1;
        while(!q.isEmpty()){
            Integer r=q.peek().row;
            Integer c=q.peek().col;
            Integer distance=q.peek().dist;
            q.poll();
            max=Math.max(max,distance);
            for(int k=0;k<4;k++){
                int nrow=r+xaxis[k];
                int ncol=c+yaxis[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]!=1){
                    visited[nrow][ncol]=1;
                    q.offer(new Pair1162(nrow,ncol,distance+1));

                }
            }
        }
        return max;
    }
}
