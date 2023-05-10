package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

class PairG36{
    int dist;
    int row;
    int col;

    public PairG36(int dist, int row, int col){
        this.dist=dist;
        this.row=row;
        this.col=col;
    }
}
public class G36BinaryMaze {

    public static void main(String[] args) {
        int[][] grid=new int[][]{{1,1,1,1},{1,1,0,1},{1,1,1,1},{1,1,0,0},{1,0,0,1}};
        int[] source=new int[]{0,0};
        int[] dest=new int[]{1,1};

        int dist=shortestDistanceInMaze(grid,source,dest);
        System.out.println("Shortest Distance is: "+dist);

        //Time Complexity: O( 4*N*M ) { N*M are the total cells, for each of which we also check 4 adjacent nodes for the shortest path length},
        // Where N = No. of rows of the binary maze and M = No. of columns of the binary maze.
        //Space Complexity: O( N*M ), Where N = No. of rows of the binary maze and M = No. of columns of the binary maze.

    }

    private static int shortestDistanceInMaze(int[][] grid, int[] source, int[] dest) {

        int n=grid.length;
        int m=grid[0].length;
        //First see if the source is same as destination then return 0 if yes

        if(source[0]==dest[0] && source[1]==dest[1]) return 0;

        //We do not need PQ as at each level we have same distance in PQ

        Queue<PairG36> q=new LinkedList<>();
        q.offer(new PairG36(0,source[0],source[1]));

        int[][] distance=new int[n][m];

        //Fill the distance array with a large value;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j]=(int)(1e9);
            }
        }
        //Setting source distance to 0
        distance[source[0]][source[1]]=0;

        //Create 4 directions
        int[] xaxis=new int[]{1,0,-1,0};
        int[] yaxis=new int[]{0,-1,0,1};

        while(!q.isEmpty()){
            int dis=q.peek().dist;
            int row=q.peek().row;
            int col=q.peek().col;
            q.poll();

            for(int k=0;k<4;k++){
                int nrow=row+xaxis[k];
                int ncol=col+yaxis[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){

                    if(nrow==dest[0]&& ncol==dest[1])
                        return dis+1;
                    if(distance[nrow][ncol]> dis+1){
                        distance[nrow][ncol]=dis+1;
                        q.offer(new PairG36(distance[nrow][ncol],nrow,ncol));
                    }
                }
            }


        }
        return -1;
    }
}
