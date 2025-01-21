package leetcode.graph;

import java.util.*;

public class G25LC802EventualSafeStatesUsingTopoSort {

    public static void main(String[] args) {

        int[][] graph =new int[][] {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }

    private static List<Integer> eventualSafeNodes(int[][] graph) {

        List<List<Integer>> adjList=new ArrayList<>();
        List<List<Integer>> reverseAdjList=new ArrayList<>();

        for(int i=0; i<graph.length; i++){
            adjList.add(new ArrayList<>());
            reverseAdjList.add(new ArrayList<>());
        }

        for(int i=0; i<graph.length; i++){
            for(int j=0;j<graph[i].length;j++){
                adjList.get(i).add(graph[i][j]);
            }
        }

        int[] indegree=new int[graph.length];

        //Reverse the Adjacency List and then increase the indegree of parent of previous list
        for(int i=0; i<adjList.size(); i++){
            for(Integer v : adjList.get(i)){
                reverseAdjList.get(v).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        List<Integer> safeNodes=new ArrayList<>();
        while(!q.isEmpty()){
            Integer node=q.poll();
            safeNodes.add(node);
            for(Integer vertex:reverseAdjList.get(node)){
                indegree[vertex]--;
                if(indegree[vertex]==0){
                    q.offer(vertex);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;

        //TC:O(nlogn) sorting + O(N+E) + O(n^2) for converting 2d array to adjlist
        //SC:O(n) indegree+ O(n) safenodes + O(2*n^2) adjlist and reverse list
        //Here extra space for adjList is used as compared previous similar question with only dfs
    }
}
