package leetcode.graph;

public class G7LC547NumberOfProvince {

    public static void main(String[] args) {
        //below are the province https://leetcode.com/problems/number-of-provinces/description/
        //0--1
        //2
        //code in leetcode also runs from index as 0
        //we can use either BFS or DFS
        int[][] matrix=new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(matrix));

    }

    public static int findCircleNum(int[][] isConnected) {

        int[] visited=new int[isConnected.length];
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==0){
                count++;
                dfs(isConnected, visited,i);
            }
        }
        return count;
    }

    public static void dfs(int[][] isConnected, int[] visited, int i){

        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && visited[j]==0){
                visited[j]=1;
                dfs(isConnected, visited, j);
            }
        }

        //SC:O(n) for visited array +o(n) recursion stack for skewed
        //TC:O(n*n) as we have to parse each element in matrix

        //if it was Adjacency list TC:O(N) outer loop +O(v+2e) for inner loop

        //IMP: for a graph having 5 disconnected graph  TC:O(N)+O(1)+O(1)+O(1)+O(1)+O(1)
        //which is equal to O(N)
    }
}
