package leetcode.graph;

import java.util.Arrays;

public class G41BellManFordAlgorithm {

    public static void main(String[] args) {

        //1. Used in DG, if the graph is UG then add two edges instead of one in both directions
        //2. Used for SSSP(Single source shortest path)
        //3. Relax all the edges sequentially
        //4. It takes more time than Dijsktra
        //5. Use this algo if ur graph have negative edges else use Dijsktra

        int V=6;
        int E=7;
        int src=0;
        int[][] edges=new int[][]{{3,2,6}, {5,3,1}, {0,1,5}, {1,5,-3}, {1,2,-2}, {3,4,-2}, {2,4,3}};

        int[] arr = bellManFord(V,E,edges,src);

        System.out.println("Shortest distance if found is :");
        for(int n:arr)
            System.out.println(n);

        //TC:O(V*E)
        //SC:O(N) distance
        //Most of the questions are solved using Dijkstra but Bellman ford can be a follow up question
        //for negative weights or graphs with negative cycle
    }

    private static int[] bellManFord(int n, int e, int[][] edges,int src) {

        int[] dist=new int[n];
        Arrays.fill(dist,(int)(1e9));
        dist[src]=0;

        //Doing n-1 iterations
        for(int i=0; i<n-1; i++){
            for(int[] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                if(dist[u]!=(int)(1e9) && dist[u]+wt < dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }

        int[] negArray=new int[n];
        Arrays.fill(negArray,-1);

        //Checking if -ve cycle exists
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            if(dist[u]!=1e9 && dist[u]+wt < dist[v]){
                return negArray;
            }
        }
         return dist;
    }
}
