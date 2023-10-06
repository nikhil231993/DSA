package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class G36LC1036BinaryMatrix {

    public static void main(String[] args) {

        int[][] grid=new int[][]{{1,0,0},{1,1,0},{1,1,0}};
        int n=grid.length;
        int m=grid[0].length;

        int[] source=new int[]{0,0};
        int[] dest=new int[]{n-1,m-1};

        System.out.println(shortestDistanceInMaze(grid,source,dest,n,m));
    }

    private static int shortestDistanceInMaze(int[][] grid, int[] source, int[] dest,int n, int m) {
        if(grid[0][0]==1 || grid[m-1][n-1]==1) {
            return -1;
        }

        //grid =
        //[[0]]
        //Below is to handle above case
        if(grid[0][0]==0 && n==1 && m==1)
            return 1;

        Queue<PairG36> q=new LinkedList<>();
        q.offer(new PairG36(1,source[0],source[1]));

        int[][] distance=new int[n][n];

        //Fill the distance array with a large value;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=(int)(1e9);
            }
        }
        int[][] visited=new int[n][n];

        //Setting source distance to 0
        distance[source[0]][source[1]]=1;

        //Create 4 directions
        int[] xaxis=new int[]{1,0,-1,0,1,1,-1,-1};
        int[] yaxis=new int[]{0,-1,0,1,1,-1,-1,1};

        while(!q.isEmpty()){
            int dis=q.peek().dist;
            int row=q.peek().row;
            int col=q.peek().col;
            q.poll();
//             if(visited[row][col]==1) This will improve the speed.
//                continue;
//            visited[row][col]=1;

            for(int k=0;k<8;k++){
                int nrow=row+xaxis[k];
                int ncol=col+yaxis[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0){
                    //We can do below check even before above for loop.i.e., because since here the distance is
                    //constant, whenever we reach corner that will be the fastest.
                    if(nrow==dest[0]&& ncol==dest[1]){
                        return dis+1;
                    }
                    if(distance[nrow][ncol]> distance[row][col]+1){
                        distance[nrow][ncol]=distance[row][col]+1;
                        q.offer(new PairG36(distance[nrow][ncol],nrow,ncol));
                    }
                }
            }
        }
        return -1;
    }
}
