package leetcode.graph;

import java.util.*;

class PairG32{

    protected int weight;
    protected int node;

    public PairG32(int node,int weight){
        this.weight=weight;
        this.node=node;
    }
}

public class G32DijkstraAlgoUGWeight {

    public static void main(String[] args) {

        int[][] edge = new int[][] { { 0, 2, 4 },
                { 0, 1, 4 }, {1,2,2},{ 2, 3, 3 }, { 2, 4, 1 },
                { 3, 5, 2 }, { 2, 5, 6 }, { 4, 5, 3 } };

        // Dijkstra not applicable for graph with negative weights and negative cycle

        // Below we can see in comments of the video G-33:
        //Ques:I just had one doubt will the T.C of the priority queue method be O(ElogE) instead of O(ElogV)
        // as there can be more than one instance of a node in the priority queue whereas in the treeset
        // method it will be O(ElogV)
        //Ans: Yes
        // Also in here we use (v * ((pop vertex from min heap) + no of edges on each vertex *push into PQ) Here it is V* because we parse everything in for loop also which is present inside
        //TC  if we use Queue instead of priority queue will be EV
        int V=6;
        int E=8;
        int src=0;

        int[] arr=shortestPath(edge,V,E,src);

        for(Integer n: arr)
            System.out.println(n);

        System.out.println("#########################");

        //TC:ElogV as there can be more edges in PQ

        //Even with Q instead of PQ we will get answer but why PQ will be in next video?
        //Even if we use visited array then also we will get the optimal answer

        int[] arrVisited=shortestPathUsingVisited(edge,V,E,src);

        for(Integer n: arrVisited)
            System.out.println(n);
    }

    private static int[] shortestPathUsingVisited(int[][] edge, int V, int E, int src) {
        List<List<PairG32>> adjList=new ArrayList<>();

        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<E;i++){
            adjList.get(edge[i][0]).add(new PairG32(edge[i][1],edge[i][2]));
            adjList.get(edge[i][1]).add(new PairG32(edge[i][0],edge[i][2]));
        }

        Queue<PairG32> q=new PriorityQueue<>((a,b)->a.weight-b.weight);
        int[] dist=new int[V];
        int[] visited=new int[V];

        Arrays.fill(dist,(int)(1e9));
        dist[src]=0;

        q.offer(new PairG32(src,0));
        while(!q.isEmpty()){

            Integer node=q.peek().node;
            Integer weight=q.peek().weight;
            q.poll();

            if(visited[node]==1)
                continue;;
            visited[node]=1;

            for(PairG32 vertex:adjList.get(node)){
                    if(dist[vertex.node]>weight+vertex.weight){
                    dist[vertex.node]=weight+vertex.weight;
                    q.offer(new PairG32(vertex.node,dist[vertex.node]));
                }
            }
        }
        return dist;
    }

    private static int[] shortestPath(int[][] edge, int V, int E,int src) {

        List<List<PairG32>> adjList=new ArrayList<>();

        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<E;i++){
            adjList.get(edge[i][0]).add(new PairG32(edge[i][1],edge[i][2]));
            adjList.get(edge[i][1]).add(new PairG32(edge[i][0],edge[i][2]));
        }

        Queue<PairG32> q=new PriorityQueue<>((a,b)->a.weight-b.weight);
        int[] dist=new int[V];

        Arrays.fill(dist,(int)(1e9));
        dist[src]=0;

        q.offer(new PairG32(src,0));

        while(!q.isEmpty()){

            Integer node=q.peek().node;
            Integer weight=q.peek().weight;
            q.poll();

            for(PairG32 vertex:adjList.get(node)){
                if(dist[vertex.node]>weight+vertex.weight){
                    dist[vertex.node]= weight+vertex.weight;
                    q.offer(new PairG32(vertex.node,dist[vertex.node]));
                }
            }
        }
        return dist;
    }
}
