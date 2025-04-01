package leetcode.graph;

import java.util.*;

class PairG28{

    protected int node;
    protected int weight;

    public PairG28(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}

class Node11{

    int edge;
    int weight;
    public Node11(int edge, int weight){
        this.edge=edge;
        this.weight=weight;
    }
}

public class G28ShortestPathUGActualWeightsSelf {

    public static void main(String[] args) {

        int V = 9, E= 10;
        //Try negative weight and see what happens
        //In case of negative loop it will go as a negative cycle and will be infinite loop
        int[][] edges=new int[][]{{0,1,2},{0,3,1},{3,4,2},{4 ,5,1}
                        ,{5,6,6},{1,2,3},{2,6,4},{6,7,1},{7,8,1},{6,8,4}};
        int src=0;

        //If we change src to which does not have adj nodes all will be -1 that is not reachable

        //Creating Adjacency List
        List<List<PairG28>> adjlist=new ArrayList<>();

        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            adjlist.get(edges[i][0]).add(new PairG28(edges[i][1],edges[i][2]));
            adjlist.get(edges[i][1]).add(new PairG28(edges[i][0],edges[i][2]));
        }

        int[] dist=new int[V];
        Arrays.fill(dist,(int)(1e9));

        dist[src]=0;

        Queue<Integer> q=new LinkedList();
        q.offer(src);

        while(!q.isEmpty()){
            Integer node=q.poll();

            for(PairG28 vertex: adjlist.get(node)){
                if(dist[vertex.node] > dist[node]+vertex.weight){
                    dist[vertex.node] = vertex.weight+dist[node];
                    q.offer(vertex.node);
                }
            }
        }

        for(int i=0;i<V;i++) {
            if(dist[i]==1e9){
                dist[i]=-1;
            }
        }

        System.out.println("Shortest Path from src are: ");
        for(Integer n:dist)
            System.out.println(n);

        System.out.println("################");
        //https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
        int[][] edges1 =new int[][] {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(shortestPath(5, 6, edges1));

        //Time Complexity: O(M) { for creating the adjacency list from given list ‘edges’}
        // + O(N + 2M) { for the BFS Algorithm}
        // + O(N) { for adding the final values of the shortest path in the resultant array} ~ O(N+2M).
        //Where N= number of vertices and M= number of edges.
        //Space Complexity:  O( N) {for the stack storing the BFS}
        // + O(N) {for the resultant array}
        // + O(N) {for the dist array storing updated shortest paths} + O( N+2M) {for the adjacency list} ~ O(N+M) .
    }

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {

        ArrayList<ArrayList<Node11>> adjList=new ArrayList();
        for(int i=0;i<=n;i++)
            adjList.add(new ArrayList());
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(new Node11(edges[i][1], edges[i][2]));
            adjList.get(edges[i][1]).add(new Node11(edges[i][0], edges[i][2]));
        }

        int[] dist=new int[n+1];
        Arrays.fill(dist, (int)(1e9));
        Queue<Integer> q=new LinkedList();
        q.offer(1);
        dist[1]=0;
        int[] path=new int[n+1];
        for(int i=0;i<=n;i++)
            path[i]=i;
        path[1]=1;
        while(!q.isEmpty()){
            Integer node=q.poll();

            for(Node11 vertex: adjList.get(node)){
                if(dist[vertex.edge]>dist[node]+vertex.weight){
                    dist[vertex.edge]=dist[node]+vertex.weight;
                    path[vertex.edge]=node;
                    q.offer(vertex.edge);
                }
            }
        }

        List<Integer> list=new ArrayList();
        list.add(dist[n]);

        int variable=n;
        while(variable!=path[variable]){
            list.add(1, variable);
            variable=path[variable];
        }
        list.add(1, variable);
        return list;
    }
}
