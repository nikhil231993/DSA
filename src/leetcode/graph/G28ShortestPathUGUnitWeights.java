package leetcode.graph;

import java.util.*;

public class G28ShortestPathUGUnitWeights {
    public static void main(String[] args) {

        //IMP: we can find the shortest path for undirected unit weights with BFS as the first path
        // guarantees it is the shortest path as it goes level by level
        //1. We can do without visited array where we do not have to check the weights
        //2. BFS with visited array as we are not coming back to that node and shortest path will be taken

        //If we change src to which does not have adj nodes all will be -1 that is not reachable
        //Try changing V to 10 and src to 9 as none of the nodes are reachable it will return -1 for all vertexes

        //Below is using 1.
        int V = 9, E= 10;
        int[][] edges=new int[][]{{0,1},{0,3},{3,4},{4 ,5}
,{5, 6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        int src=0;

        //Creating Adjacency List
        List<List<Integer>> adjlist=new ArrayList<>();

        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            adjlist.get(edges[i][0]).add(edges[i][1]);
            adjlist.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist=new int[V];
        Arrays.fill(dist,(int)(1e9));

        dist[src]=0;

        Queue<Integer> q=new LinkedList();
        q.offer(src);

        while(!q.isEmpty()){
            Integer node=q.poll();

            for(Integer vertex: adjlist.get(node)){
                if(dist[vertex]>dist[node]+1){
                    dist[vertex]=1+dist[node];
                    q.offer(vertex);
                }
            }
        }

        for(int i=0;i<V;i++) {
            if(dist[i]==1e9){
                dist[i]=-1;
            }
        }

        System.out.println("Shortest path from src are: ");
        for(Integer n:dist)
            System.out.println(n);


//Time Complexity: O(M) { for creating the adjacency list from given list ‘edges’}
// + O(N + 2M) { for the BFS Algorithm}
// + O(N) { for adding the final values of the shortest path in the resultant array} ~ O(N+2M).
//Where N= number of vertices and M= number of edges.
//Space Complexity:  O( N) {for the stack storing the BFS}
// + O(N) {for the resultant array}
// + O(N) {for the dist array storing updated shortest paths} + O( N+2M) {for the adjacency list} ~ O(N+M) .

        //Below is using 2.
        int[] result=shortestPath(adjlist,V,E,src);
        System.out.println("####################");
        for(Integer n : result)
            System.out.println(n);

    }

    private static int[] shortestPath(List<List<Integer>> adjlist,int V, int E,int src) {

        int[] visited=new int[V];
        int[] dist=new int[V];

        dist[src]=0;
        visited[src]=1;
        Queue<Integer> q=new LinkedList<>();
        q.offer(src);

        while(!q.isEmpty()){
            Integer node=q.poll();

            for(Integer vertex:adjlist.get(node)){
                if(visited[vertex]==0){
                    visited[vertex]=1;
                    dist[vertex]=1+dist[node];
                    q.offer(vertex);
                }
            }
        }

        return dist;

    }
}
