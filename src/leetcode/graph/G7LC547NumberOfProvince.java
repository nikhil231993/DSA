package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G7LC547NumberOfProvince {

    public static void main(String[] args) {

        //below are the province https://leetcode.com/problems/number-of-provinces/description/
        //0--1
        //2
        //code in leetcode also runs from index as 0
        //we can use either BFS or DFS

        int[][] matrix=new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        System.out.println("Using Adjacency Matrix :"+ findCircleNum(matrix));
        System.out.println("Using Adjacency List :"+ findCircleNumUsingAdjacencyList(matrix));
    }

    private static int findCircleNumUsingAdjacencyList(int[][] matrix) {

        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<matrix.length;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1 && i!=j){
                    adjList.get(i).add(j);
                }
            }
        }

        int[] visited=new int[matrix.length];
        int count=0;
        for(int i=0;i<matrix.length;i++){
            if(visited[i]==0){
                count++;
                visited[i]=1;
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);

                while(!q.isEmpty()){
                    Integer node=q.poll();

                    for(Integer vertex:adjList.get(node)){
                        if(visited[vertex]==0){
                            visited[vertex]=1;
                            q.offer(vertex);
                        }
                    }
                }
            }
        }
        return count;

        //TC:O(V)+O(V+2E)
        //TC:O(N) visited +O(N) queue
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

        visited[i]=1;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && visited[j]==0 && i!=j){
                visited[j]=1;
                dfs(isConnected, visited, j);
            }
        }

        //SC:O(n) for visited array + O(n) recursion stack for skewed
        //TC:O(n*n) as we have to parse each element in matrix

        //if it was Adjacency list TC:O(V) outer loop +O(V+2E) for inner loop (12:53 in video)

        //IMP: for a graph having 5 disconnected graph  TC:O(N)+O(1)+O(1)+O(1)+O(1)+O(1)
        //which is equal to O(N)
    }
}
