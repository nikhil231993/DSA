package leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class PairNodeWeight{

    protected int node;
    protected int weight;

    public PairNodeWeight(int node, int weight){
        this.node=node;
        this.weight=weight;
    }
}

class PairG45{

    protected int weight;
    protected int node;
    protected int parent;

    public PairG45(int weight, int node, int parent){
        this.weight=weight;
        this.node=node;
        this.parent=parent;
    }
}

public class G45PrimAlgorithm {

    public static void main(String[] args) {

        int[][] edges=new int[][]{{0,1,2},{0,2,1},{1,2,1},{2,4,2},{2,3,2},{3,4,1}};
        int n=5;
        int src=2;
        System.out.println(minimumWeight(edges,n,src));
    }

    private static int minimumWeight(int[][] edges, int n,int src) {

        List<List<PairNodeWeight>> adjList=new ArrayList<>();
        //Create Adjacency List

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        //Adding edges
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(new PairNodeWeight(edges[i][1],edges[i][2]));
            adjList.get(edges[i][1]).add(new PairNodeWeight(edges[i][0],edges[i][2]));
        }

        //key is to store the distance
        int[] key=new int[n];
        //to store parent of each
        int[] parent=new int[n];

        int[] visited=new int[n];

        PriorityQueue<PairG45> pq=new PriorityQueue<>((a,b)->(a.weight-b.weight));
        pq.add(new PairG45(0, src, -1));
        //E
        while(!pq.isEmpty()){
            //logE
            int weight=pq.peek().weight;
            int node=pq.peek().node;
            int parentNode=pq.peek().parent;
            pq.poll();

            //Once visited we need not visit again as minimum is found
            if(visited[node]==1)
                continue;;
            visited[node]=1;

            parent[node]=parentNode;
            key[node]=weight;
            //E
            for(PairNodeWeight vertex:adjList.get(node)){
                int weigh=vertex.weight;
                int vertexAdj=vertex.node;

                if(visited[vertexAdj]==0){
                    //logE
                    pq.offer(new PairG45(weigh, vertexAdj, node));
                }
            }
        }
        System.out.println("Parent and child are");
        for(int i=0;i<n;i++){
            System.out.println(parent[i]+"----"+i);
        }

        System.out.println("Minimum weight is: ");
        int sum=0;
        for(int num:key)
            sum+=num;
        return sum;

        //TC:ElogE + ElogE
        //SC:O(N) key+O(N) parent +O(2E) edges +O(N) visited
    }
}
