package leetcode.graph;

import java.util.*;

public class G35PrintShortestPathUG {

    public static void main(String[] args) {

        int[][] edge = new int[][] { { 1, 2, 2 },
                { 2, 5, 5 }, {1,4,1},{ 4, 3, 3 }, { 2, 3, 4 },
                { 3, 5, 1 }};

        int V=5;
        int E=6;
        int src=1;
        int dest=5;

        int[] dist=new int[V+1];
        int[] path=shortestPath(edge, V, E, src, dest, dist);

        //If we are not able to reach then dest then it will 1e9
        if(dist[dest]==1e9)
            System.out.println("Path does not exist");

        System.out.println("#######Path is :");

        List<Integer> pathList=new ArrayList<>();
        int variable=dest;

        //at max this might be a linear graph
        while(path[variable]!=variable){
            pathList.add(variable); // pathList.add(0, variable) can be used which will avoid Collection.reverse() call
            variable=path[variable];
        }
        pathList.add(src); // pathList.add(0, src);
        // Collections.reverse(pathList);
        System.out.println(pathList);

        //Time Complexity: O( E log(V) ) { for Dijkstra’s Algorithm } +
        // O(V) { for backtracking in order to find the parent for each node }
        // Where E = Number of edges and V = Number of Nodes.

        //Space Complexity: O( |E| + |V| ) { for priority queue and dist array } +
        // O( |V| ) { for storing the final path } Where E = Number of edges and V = Number of Nodes.
    }

    private static int[] shortestPath(int[][] edge, int V, int E,int src, int des,int[] dist) {

        List<List<PairG32>> adjList=new ArrayList<>();

        for(int i=1;i<=V+1;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            adjList.get(edge[i][0]).add(new PairG32(edge[i][1],edge[i][2]));
            adjList.get(edge[i][1]).add(new PairG32(edge[i][0],edge[i][2]));
        }

        Arrays.fill(dist,(int)(1e9));
        dist[src]=0;

        int[] parent=new int[V+1];

        //Mark all parents with themselves
        for(int i=0;i<parent.length;i++)
            parent[i]=i;
        parent[src]=src;

        Queue<PairG32> q=new PriorityQueue<>((a,b)->a.weight-b.weight);
        q.offer(new PairG32(src,0));

        while(!q.isEmpty()){
            Integer node=q.peek().node;
            Integer weight=q.peek().weight;
            q.poll();

            for (PairG32 vertex : adjList.get(node)){
                if(dist[vertex.node]>weight+vertex.weight){
                    parent[vertex.node]=node;
                    dist[vertex.node]=weight+vertex.weight;
                    q.offer(new PairG32(vertex.node, dist[vertex.node]));
                }
            }
        }
       return parent;
    }
}