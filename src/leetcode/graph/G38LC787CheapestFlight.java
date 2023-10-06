package leetcode.graph;

import java.util.*;

class PairSrcDest{
    int dest;
    int distance;

    public PairSrcDest(int dest, int distance){
        this.dest=dest;
        this.distance=distance;
    }
}
class PairG38{
    int stop;
    int node;
    int distance;

    public PairG38(int stop, int node, int distance){
        this.stop=stop;
        this.node=node;
        this.distance=distance;
    }
}
public class G38LC787CheapestFlight {

    public static void main(String[] args) {
//        int[][] flights=new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        int[][] flights=new int[][]{{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int V=5;
        int E=6;
//        int V=3;
//        int E=3;
        int src=0;
        int dest=2;
        int k=2;
//        int k=2;

        System.out.println("Shortest distance with required stop is :"+shortestPath(flights,V,E,src,dest,k));
    }

    private static int shortestPath(int[][] flights, int V, int E,int src, int dest, int k) {

        List<List<PairSrcDest>> adjList=new ArrayList<>();

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adjList.get(flights[i][0]).add(new PairSrcDest(flights[i][1],flights[i][2]));
        }

        int[] dist=new int[V];
        Arrays.fill(dist,(int)(1e9));

        dist[src]=0;
        //Q because stop will be same at each level
        Queue<PairG38> q=new LinkedList<>();
        q.offer(new PairG38(0,src,0));

        while(!q.isEmpty()){
            int stop=q.peek().stop;
            int node=q.peek().node;
            int distance=q.peek().distance;
            q.poll();

            //we can break also after below condition as then we cannot have a solution to the question
            if(stop>k) break;
            for(PairSrcDest vertex:adjList.get(node)){
                int destination=vertex.dest;
                int edW=vertex.distance;

                //below stop<=k is not required
                if(stop <=k && dist[destination]>edW+distance){
                    dist[destination]=edW+distance;
                    q.offer(new PairG38(stop+1,destination,edW+distance));
                }
            }
        }
        System.out.println("All other destination shortest distance is :");
        for(Integer n : dist)
            System.out.println(n);

        if(dist[dest]==(int)(1e9))
            return -1;
        return dist[dest];

//        Time Complexity: O( N ) { Additional log(N) of time eliminated here because we’re using a simple queue
//        rather than a priority queue which is usually used in Dijkstra’s Algorithm }.
//        Where N = Number of flights / Number of edges.

//       Space Complexity:  O( |E| + |V| ) { for the adjacency list, priority queue, and the dist array }.
//       Where E = Number of edges (flights.size()) and V = Number of Airports.
    }
}
