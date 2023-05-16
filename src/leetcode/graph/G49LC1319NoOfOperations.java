package leetcode.graph;

public class G49LC1319NoOfOperations {

    public static void main(String[] args) {
//        int n = 4;
//        int[][] connections =new int[][] {{0,1},{0,2},{1,2}};

        int n = 6;
        int[][] connections =new int[][] {{0,1},{0,2},{0,3},{1,2},{1,3}};

        System.out.println(noOfOperations(n,connections));
    }

    private static int noOfOperations(int n, int[][] connections) {

        DisjointSetBySize ds=new DisjointSetBySize(n);
        int countExtraEdges=0;
        for(int[] r: connections){
            if(ds.findParent(r[0])== ds.findParent(r[1])){
                countExtraEdges++;
            }else{
                ds.unionBySize(r[0],r[1]);
            }
        }

        int noOfComponents=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i){
                noOfComponents++;
            }
        }

        if(countExtraEdges>=noOfComponents-1)
            return noOfComponents-1;
        return-1;
//Time Complexity: O(E*4α)+O(N*4α) where E = no. of edges and N = no. of nodes.
// The first term is to calculate the number of extra edges and the second term is to count the number of components.
// 4α is for the disjoint set operation we have used and this term is so small that it can be considered constant.
//
//Space Complexity: O(2N) where N = no. of nodes. 2N for the two arrays(parent and size) of size N we have
// used inside the disjoint set.
    }
}
