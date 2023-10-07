package leetcode.graph.medium;

public class LC1254NumberOfClosedIslands {

    public static void main(String[] args) {
        int[][] grid =new int[][] {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};

        System.out.println(closedIsland(grid));;
    }

    public static int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1};
        int vis[][] = new int[n][m];
        // traverse first row and last row
        for(int j = 0 ; j<m;j++) {
            // check for unvisited Os in the boundary rws
            // first row
            if(vis[0][j] == 0 && grid[0][j] == 0) {
                dfs(0, j, vis, grid, delrow, delcol);
            }

            // last row
            if(vis[n-1][j] == 0 && grid[n-1][j] == 0) {
                dfs(n-1,j,vis,grid, delrow, delcol);
            }
        }

        for(int i = 0;i<n;i++) {
            // check for unvisited Os in the boundary columns
            // first column
            if(vis[i][0] == 0 && grid[i][0] == 0) {
                dfs(i, 0, vis, grid, delrow, delcol);
            }

            // last column
            if(vis[i][m-1] == 0 && grid[i][m-1] ==0 ) {
                dfs(i, m-1, vis, grid, delrow, delcol);
            }
        }

        // if unvisited O then convert to X
        int count=0;
        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(vis[i][j] == 0 && grid[i][j] == 0)
                {
                    count++;
                    dfs(i, j, vis, grid, delrow, delcol);
                }

            }
        }
        return count;
    }

    public static void dfs(int row, int col,int vis[][],
                           int grid[][], int delrow[], int delcol[]) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        // check for top, right, bottom, left
        for(int i = 0;i<4;i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            // check for valid coordinates and unvisited Os
            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 0) {
                dfs(nrow, ncol, vis, grid, delrow, delcol);
            }
        }
        //TC:O(N) boundary rows+O(N) boundary columns+O(N^2 *4) bfs
        //SC:O(N^2) visited array+O(N^2)auxiliary space worst case
    }
}
