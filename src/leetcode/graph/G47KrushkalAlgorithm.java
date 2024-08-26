package leetcode.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pair47{

    protected int node;
    protected int dist;

    public Pair47(int node, int dist){
        this.node=node;
        this.dist=dist;
    }
}

class Edge implements Comparable<Edge>{

    protected int wt;
    protected int u;
    protected int v;

    public Edge(int wt, int u, int v){
        this.wt=wt;
        this.u=u;
        this.v=v;
    }

    @Override
    public int compareTo(Edge o) { return this.wt-o.wt;
    }
}

class PairEdges{

    protected int u;
    protected int v;

    public PairEdges(int u,int v){
        this.u=u;
        this.v=v;
    }
}

public class G47KrushkalAlgorithm {

    public static void main(String[] args) {

        int V = 5;
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        //Creating a list of edge having wt, u, v
        //O(N+E) is TC here
        List<Edge> edgeList=new ArrayList<>();
        for(int[] row:edges){
            edgeList.add(new Edge(row[2],row[0],row[1]));
        }

        //To sort based on weight to have minimum weight at top
        //O(MlogM)
        Collections.sort(edgeList);

        //Disjoint Set
        DisjointSetBySize ds=new DisjointSetBySize(V);

        int sum=0;
        List<PairEdges> pairEdge=new ArrayList<>();

        //O(M*4*alpha*2)
        for(Edge edge:edgeList){
            int u=edge.u;
            int v=edge.v;
            int wt=edge.wt;

            if(ds.findParent(u)!=ds.findParent(v)){
                pairEdge.add(new PairEdges(u,v));
                sum+=wt;
                ds.unionBySize(u,v);
            }
        }

        System.out.println("Minimum Weight of Spanning tree is: "+sum);
        System.out.println("Pair of edges are:");

        for(PairEdges e:pairEdge){
            System.out.println(e.u+"--"+e.v);

        //Time Complexity: O(N+E) + O(E logE) + O(E*4α*2)   where N = no. of nodes and
        // E = no. of edges. O(N+E) for extracting edge information from the adjacency list.
        // O(E logE) for sorting the array consists of the edge tuples.
        // Finally, we are using the disjoint set operations inside a loop. The loop will continue to E times.
        // Inside that loop, there are two disjoint set operations like findUPar() and UnionBySize() each taking 4α
        // and so it will result in 4α*2. That is why the last term O(E*4*2) is added.
        //Space Complexity: O(N) + O(N) + O(E) where E = no. of edges and N = no. of nodes.
        // O(E) space is taken by the array that we are using to store the edge information.
        // And in the disjoint set data structure, we are using two N-sized arrays
        // i.e. a parent and a size array (as we are using unionBySize() function otherwise,
        // a rank array of the same size if unionByRank() is used) which result in the first two terms O(N).
        }
    }
}
