package leetcode.graph;

import java.util.HashSet;
import java.util.Set;

public class G52LC827MakingLargeIsland {

    public static void main(String[] args) {

       int[][] grid =new int[][] {{1,1},{1,1}};
        System.out.println(makingLargeIsland(grid));
    }

    private static int makingLargeIsland(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;
        DisjointSetBySize ds=new DisjointSetBySize(n*m);

        //Step 1: Loop through the matrix and create union
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                //Islands are formed only by 1
                if(grid[i][j]==0)
                    continue;
                int[] xaxis=new int[]{1,0,-1,0};
                int[] yaxis=new int[]{0,-1,0,1};

                for(int k=0;k<4;k++){
                    int nrow = i + xaxis[k];
                    int ncol = j + yaxis[k];

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                        int nnode= nrow * m +  ncol;
                        int node= i * m + j;
                        ds.unionBySize(node, nnode);
                    }
                }
            }
        }
        //Step 2: find the parent of each node
        int max=-1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //No need to convert a 1 to 0
                if (grid[i][j]==1)
                    continue;

                int[] xaxis=new int[]{1,0,-1,0};
                int[] yaxis=new int[]{0,-1,0,1};
                Set<Integer> parent=new HashSet<>();
                for(int k=0;k<4;k++) {
                    int nrow = i + xaxis[k];
                    int ncol = j + yaxis[k];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1) {
                        int ultimate_Parent=ds.findParent(nrow*m+ncol);
                        parent.add(ultimate_Parent);
                    }
                }

                //Step 3: parse through set and find the size of each parent and add it
                int sumTotal=0;
                for(Integer p:parent){
                    sumTotal+=ds.size[p];
                }

                max=Math.max(max, sumTotal+1);
            }
        }

        //Step 4: to handle the scenario where all are 1

        for(int i=0; i<n*m; i++){
            max=Math.max(max, ds.size[ds.findParent(i)]);
        }
        return max;

        //Time Complexity: O(N^2*4)+O(N^2*4) ~ O(N2) where N = total number of rows of the grid.
        // Inside those nested loops, all the operations are taking apparently constant time.
        // So, O(N2) for the nested loop only, is the time complexity.

        //Space Complexity: O(2*N2) where N = the total number of rows of the grid.
        // This is for the two arrays i.e. parent array and size array of size N2 inside the Disjoint set.
    }
}
