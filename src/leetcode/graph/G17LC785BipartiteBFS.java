package leetcode.graph;

import java.util.*;

public class G17LC785BipartiteBFS {

    public static void main(String[] args) {
        int[][] graph=new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(biPartiteUsingbfs(graph));
    }

    private static boolean biPartiteUsingbfs(int[][] graph) {

        int n=graph.length;
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList());

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adjList.get(i).add(graph[i][j]);
            }
        }
        System.out.println("Converting Adj matrix to adj list");
        int j=0;
        for(List<Integer> l:adjList){
            System.out.println(j++ +" "+l);
        }

        System.out.println("################################");

        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
                if(bfs(color,graph,i,adjList)==false)
                    return false;
            }
        }
        return true;
    }

    private static boolean bfs(int[] color,int[][] graph, int i, List<List<Integer>> adjList) {

        color[i]=0;

        Queue<Integer> q=new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            Integer node=q.poll();

            for(Integer vertex: adjList.get(node)){
                if(color[vertex]==-1){
                    color[vertex]=1-color[node];
                    q.add(vertex);
                }else if(color[vertex]==color[node]){
                    return false;
                }
            }
        }
        return true;
        //TC:O(N+2E) while loop+O(N) outer for loop
        //SC:O(N) color array+O(N) queue
    }
}
