package leetcode.graph;

import java.util.*;

class PairG16{
    int first;
    int second;

    public PairG16(int first,int second){
        this.first=first;
        this.second=second;
    }
}
public class G16PremiumNumberOfDistinctIslands {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,1,0,1,1},{1,0,0,0,0},{0,0,0,1,1},{1,1,0,1,0}};
        System.out.println(noOfDistinctIslandsUsingDfs(grid));
        System.out.println(noOfDistinctIslandsUsingBfs(grid));

    }

    private static int noOfDistinctIslandsUsingBfs(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] visited=new int[n][m];
        int[] xaxis=new int[]{1,0,-1,0};
        int[] yaxis=new int[]{0,-1,0,1};
        Set<List<String>> s=new HashSet<>();
        Queue<PairG16> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    List<String> list=new ArrayList<>();
                    visited[i][j]=1;
                    q.offer(new PairG16(i,j));
                    bfs(i,j,xaxis,yaxis,visited,grid,n,m,i,j,list,q);
                    s.add(list);
                }
            }
        }
        return s.size();

        //TC:o(m*n)*log(m*n) outer loop+dfs O(m*n)
        //SC:O(n*m) visited + O(m*n) queue
    }

    private static void bfs(int row, int col, int[] xaxis, int[] yaxis, int[][] visited, int[][] grid, int n, int m, int ro, int co,List<String> list,Queue<PairG16> q) {



        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.poll();
            list.add(toString(row-ro,col-co));

            for(int k=0;k<4;k++){
                int nrow=r+xaxis[k];
                int ncol=c+yaxis[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.offer(new PairG16(nrow,ncol));
                    visited[nrow][ncol]=1;
                }
            }
        }


    }

    private static int noOfDistinctIslandsUsingDfs(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int[] xaxis=new int[]{1,0,-1,0};
        int[] yaxis=new int[]{0,-1,0,1};
        Set<List<String>> s=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]==1 && visited[i][j]==0){
                    List<String> list=new ArrayList<>();
                    dfs(i,j,n,m,visited,grid,xaxis,yaxis,list,i,j);
                    s.add(list);
                }
            }
        }

        return s.size();

    }

    private static void dfs(int row, int col, int n, int m, int[][] visited, int[][] grid, int[] xaxis, int[] yaxis, List<String> list,int rorigin,int corigin) {
    visited[row][col]=1;
    list.add(toString(row-rorigin,col-corigin));

    for(int k=0;k<4;k++){
        int nrow=row+xaxis[k];
        int ncol=col+yaxis[k];
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0&& grid[nrow][ncol]==1){
            dfs(nrow,ncol,n,m,visited,grid,xaxis,yaxis,list,rorigin,corigin);
        }


    }
    }

    private static String toString(int r, int c) {

        return Integer.toString(r)+" "+Integer.toString(c);
    }
}
