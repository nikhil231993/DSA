package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class G20LC802EventualSafeStates {

    public static void main(String[] args) {
        int[][] graph =new int[][] {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int m=graph[0].length;
        List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adjList.get(i).add(graph[i][j]);
            }
        }

        for(int i=0;i<n;i++){
            System.out.println(adjList.get(i));
        }

        int[] visited=new int[n+1];
        int[] pathVis=new int[n+1];
        int[] safeNodes=new int[n+1];
        for(int i=0;i<n;i++){
             if(visited[i]==0){
                 dfs(i,n,m,visited,pathVis,safeNodes,adjList);
            }
        }
        List<Integer> safe=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safeNodes[i]==1){
                safe.add(i);
            }
        }
        return safe;
    }

    private static boolean dfs(int i, int n, int m, int[] visited, int[] pathVis, int[] safeNodes, List<List<Integer>> adjList) {
    visited[i]=1;
    pathVis[i]=1;
    safeNodes[i]=0;//not needed as by default it is 0

        for(Integer vertex:adjList.get(i)){
            if(visited[vertex]==0){
                if(dfs(vertex,n,m,visited,pathVis,safeNodes,adjList)){
                    return true;
                }
            }else if(pathVis[vertex]==1){
                return true;
            }
        }
        pathVis[i]=0;
        safeNodes[i]=1;
        return false;
        //TC:o(N)+O(N+E)
        //SC:O(3N) visited array,path visited array and safe +O(N) recursion stack
    }


}
