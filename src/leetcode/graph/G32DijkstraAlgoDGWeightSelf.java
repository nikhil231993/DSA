package leetcode.graph;

import java.util.*;

public class G32DijkstraAlgoDGWeightSelf {

    public static void main(String[] args) {
        int[][] edge = new int[][] { { 0, 2, 4 },
                { 0, 1, 1 }, {1,2,2},{ 2, 3, 3 }, { 2, 4, 1 },
                { 3, 5, 2 }, { 2, 5, 6 }, { 4, 5, 3 } };

        int V=6;
        int E=8;
        int src=0;

        int[] arr=shortestPath(edge,V,E,src);

        for(Integer n: arr)
            System.out.println(n);

        System.out.println("#########################");

        //TC:ElogE as there can be more edges in PQ

        //Even with Q instead of PQ we will get answer but why PQ will be in next video?

        //If we use visited  array then we will not get the optimal answer
        //Uncomment and see what happens

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
            if(visited[node]==1) continue;;

            visited[node]=1;

            for(PairG32 vertex:adjList.get(node)) {
//                if (visited[vertex.node] == 0) {
                    if (dist[vertex.node] > dist[node] + vertex.weight) {
//                        visited[vertex.node] = 1;
                        dist[vertex.node] = dist[node] + vertex.weight;
                        q.offer(new PairG32(vertex.node, dist[vertex.node]));
                    }
//                }
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
                if(dist[vertex.node]>dist[node]+vertex.weight){
                    dist[vertex.node]=dist[node]+vertex.weight;
                    q.offer(new PairG32(vertex.node,dist[vertex.node]));
                }
            }
        }

        return dist;



    }
}
