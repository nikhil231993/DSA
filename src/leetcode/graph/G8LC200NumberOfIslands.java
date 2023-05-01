package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}
public class G8LC200NumberOfIslands {

    public static void main(String[] args) {

        char[][] grid=new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        G8LC200NumberOfIslands g=new G8LC200NumberOfIslands();
        System.out.println(g.numIslands(grid));

        //Without graph using flood fill algo
        System.out.println(g.recursion(grid));


    }

    private int recursion(char[][] grid) {
        
        int n= grid.length;;
        int m=grid[0].length;
        if(n==0)
            return 0;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1') {
                    count++;
                    dfs(grid, n, m, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int n, int m, int i, int j) {

        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]!='1')
            return;
        grid[i][j]='0';
        dfs(grid,n,m,i+1,j);
        dfs(grid,n,m,i-1,j);
        dfs(grid,n,m,i,j+1);
        dfs(grid,n,m,i,j-1);

        //TC:O(n*m) worst case where we have to color everything
        //SC:O(n*m) stack has all the elements
    }

    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(grid, visited,n,m,i,j);
                }
            }
        }
        return count;


    }

    public void bfs(char[][] grid, int[][] visited, int n, int m,int row,int col){
        visited[row][col]=1;
        Queue<Pair> q=new LinkedList();
        q.offer(new Pair(row,col));
        while(!q.isEmpty()){
            int first=q.peek().first;
            int second=q.peek().second;
            q.poll();

            int[] x_axis=new int[]{1,0,-1,0};
            int[] y_axis=new int[]{0,-1,0,1};
            for(int k=0;k<4;k++){
                int neigh_row=first+x_axis[k];
                int neigh_col=second+y_axis[k];
                if( neigh_row>=0 && neigh_row<n && neigh_col>=0 && neigh_col<m && visited[neigh_row][neigh_col]==0 && grid[neigh_row][neigh_col]=='1'){
                    q.offer(new Pair(neigh_row,neigh_col));
                    visited[neigh_row][neigh_col]=1;
                }

            }
            //SC:O(N square)visited matrix +O(N^2) if q is fully occupied
            //TC:O(n^2 + n^2 *4)
        }


    }
}
