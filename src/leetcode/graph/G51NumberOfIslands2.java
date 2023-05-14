package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class G51NumberOfIslands2 {
    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        System.out.println(numberOfIslands(n,m,operators));
    }

    private static List<Integer> numberOfIslands(int n, int m, int[][] operators) {

        //First we need a visited matrix to know whether it is land or not
        int[][] visited=new int[n][m];

        //Here we will treat each cell as a separate component
        DisjointSetBySize ds=new DisjointSetBySize(n*m);
        int count=0;

        //Answer list
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<operators.length;i++){
            int row=operators[i][0];
            int col=operators[i][1];

            //If the cell is visited then ans remains same
            if(visited[row][col]==1){
                ans.add(count);
                continue;
            }

            visited[row][col]=1;
            count++;

            int[] xaxis=new int[]{1,0,-1,0};
            int[] yaxis=new int[]{0,-1,0,1};

            for(int k=0;k<4;k++){
                int nrow=row+xaxis[k];
                int ncol=col+yaxis[k];
                //Here we should multiply by column
                int nnode=nrow*m+ncol;
                int node=row*m+col;

                if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && visited[nrow][ncol]==1){
                    if(ds.findParent(nnode) != ds.findParent(node)){
                        count--;
                        ds.unionBySize(nnode,node);
                    }
                }
            }
            ans.add(count);
        }
        return ans;

        //Time Complexity: O(Q*4α) ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.
        //
        //Space Complexity: O(Q) + O(N*M) + O(N*M), where Q = no. of queries, N = total no. of rows, M = total no. of columns. The last two terms are for the parent and the size array used inside the Disjoint set data structure. The first term is to store the answer.
    }

}
