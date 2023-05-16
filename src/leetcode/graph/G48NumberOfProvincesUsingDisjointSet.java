package leetcode.graph;

public class G48NumberOfProvincesUsingDisjointSet {

    public static void main(String[] args) {
        int[][] matrix=new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        int n=3;
        System.out.println("Number of provinces are: "+countProvinces(matrix,3));
    }
        private static int countProvinces(int[][] matrix,int n) {

        int rowLength=matrix.length;
        int colLength= matrix[0].length;
        int count=0;
        //Step 1:Parse through the matrix and find the union of each cell where values are 1

            DisjointSetBySize ds=new DisjointSetBySize(n);
            for(int i=0;i<rowLength;i++){
                for(int j=0;j<colLength;j++){
                    if(i!=j && matrix[i][j]==1){
                        ds.unionBySize(i,j);
                    }
                }
            }
        //Step 2: In case of nodes having themselves as parent that is the count of no of provinces
            for(int i=0;i<n;i++){
                    if(ds.parent[i]==i){
                        count++;
                    }
            }
            return count;
            //TC:o(n*m *4 *alpha) for matrix in step 1 +O(n) no of nodes for step 2
            //SC:O(N) parent+O(N) size array
        }
}

