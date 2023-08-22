package leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class  G56ArticulationPoint {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1}, {1, 4},
                {2, 4}, {2, 3}, {3, 4}
        };

        //Step 1: convert graph to adjList
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        System.out.println(articulationPoint(n,adjList));

    }

    private static List<Integer> articulationPoint(int V, ArrayList<ArrayList<Integer>> adjList) {

        int[] visited=new int[V];
        int[] tin=new int[V];
        int[] low=new int[V];
        int[] arr=new int[V];

        dfs(0,-1,adjList,V,visited,tin,low,arr);
        //Output is needed in sorted order so sorting

        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1)
                result.add(i);
        }

        if(result.size()==0){
            result.add(-1);
            return result;
        }
        return result;
    }
    public static  int timer=1;

    private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adjList, int n, int[] visited, int[] tin, int[] low, int[] arr) {
    visited[node]=1;
    tin[node]=timer;
    low[node]=timer;
    timer++;

    int child=0;
    for(Integer vertex: adjList.get(node)){
        if(vertex==node) continue;
        if(visited[vertex]==0){

            dfs(vertex,node,adjList,n,visited,tin,low,arr);
            low[node]=Math.min(low[node],low[vertex]);

            if(low[vertex]>=tin[node] && parent!=-1){
                arr[node]=1;
            }
            child++;
        }else{
            low[node]=Math.min(low[node],tin[vertex]);
        }
    }
    if(child>1 && parent==-1)
        arr[node]=1;

    //Time Complexity: O(V+2E), where V = no. of vertices, E = no. of edges. It is because the algorithm is just a simple DFS traversal.
        //Space Complexity: O(3V), where V = no. of vertices. O(3V) is for the three arrays i.e. tin, low, and vis, each of size V.
    }
}
