package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

class PairG13{
    int row;
    int col;
    int dist;
    public PairG13(int row, int col, int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}
public class G13LC542Matrix01 {

    public static void main(String[] args) {

        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int n=mat.length;
        int m=mat[0].length;
        int[][] ma=updateMatrix(mat);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(ma[i][j]);
            }
            System.out.println();
        }

    }

    public static int[][] updateMatrix(int[][] mat) {

        int n=mat.length;
        int m=mat[0].length;
        int[][] visited=new int[n][m];
        int[][] dist=new int[n][m];

        Queue<PairG13> q=new LinkedList();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    visited[i][j]=1;
                    // dist[i][j]=0;
                    q.offer(new PairG13(i,j,0));
                }
            }
        }
        int[] xaxis=new int[]{1,0,-1,0};
        int[] yaxis=new int[]{0,-1,0,1};
        //start bfs
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int level=q.peek().dist;

            q.poll();

            dist[row][col]=level;

            for(int i=0;i<4;i++){
                int nrow=row+xaxis[i];
                int ncol=col+yaxis[i];

                if(nrow>=0 && nrow< n && ncol>=0 && ncol<m && visited[nrow][ncol] !=1){
                    visited[nrow][ncol]=1;
                    q.offer(new PairG13(nrow,ncol,level+1));
                }
            }


        }

        return dist;
        //TC:O(m*n) for loop +O(m*n*4) bfs
        //SC:O(m*n) visited array +O(m*n) queue is full incase of all elemnts are 0
    }
}