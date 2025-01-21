package leetcode.graph;

import java.util.PriorityQueue;

 class PairG37{

    protected int diff;
    protected int row;
    protected int col;

    public PairG37(int diff, int row, int col){
        this.diff=diff;
        this.row=row;
        this.col=col;
    }
}

public class G37LC1631AbsoluteDIffPath {

    public static void main(String[] args) {

        int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(maxAbsolutPathDiff(heights));
    }

    private static int maxAbsolutPathDiff(int[][] heights) {

        PriorityQueue<PairG37> pq=new PriorityQueue<>((a,b)->a.diff-b.diff);
        int n=heights.length;
        int m=heights[0].length;

        int[][] diff=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j]=(int) 1e9;
            }
        }

        //SET ABSOLUTE DIFF FOR SOURCE AS 0
        diff[0][0]=0;

        //row and col are 0 as it is mentioned it starts from 0,0
        pq.offer(new PairG37(0,0,0));

        int[] xaxis=new int[]{1,0,-1,0};
        int[] yaxis=new int[]{0,-1,0,1};

        while (!pq.isEmpty()){
            int height=pq.peek().diff;
            int row=pq.peek().row;
            int col=pq.peek().col;
            pq.poll();

            //we check the value while taking out of PQ because we might reach right corner with max values as well
            //Try dry run with example in question, and you will find out
            if(row == n-1 && col == m-1)
                return height;

            for(int k=0;k<4;k++){
                int nrow=row+xaxis[k];
                int ncol=col+yaxis[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int maxDiff=Math.max(height, Math.abs(heights[row][col] - heights[nrow][ncol]));
                    if(maxDiff < diff[nrow][ncol]) {
                        diff[nrow][ncol] = maxDiff;
                        pq.offer(new PairG37(maxDiff, nrow, ncol));
                    }
                }
            }
        }
        return 0;// unreachable

        //TC:O(ElogV) i.e O(n*m*4*log(n*m))
        //SC:O(m*n)
    }
}
