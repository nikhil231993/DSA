package leetcode.graph;

class DisjointSetByRank{

    protected int[] rank=null;
    protected int[] parent=null;

    public DisjointSetByRank(int n){

        rank=new int[n+1];
        parent=new int[n+1];
        for(int i=0;i<=n;i++)
            parent[i]=i;
    }

    public int findParent(int node){

        if(node==parent[node])
            return node;
        return parent[node]=findParent(parent[node]);
    }

    public void unionByRank(int u,int v){

        int parent_U = findParent(u);
        int parent_V = findParent(v);
        //If they belong to same component don't do anything
        if(parent_U == parent_V) return;

        int rank_U = rank[parent_U];
        int rank_V = rank[parent_V];

        if(rank_U < rank_V){
            parent[parent_U] = parent_V;
        }else if(rank_U > rank_V){
            parent[parent_V] = parent_U;
        }else{
            parent[parent_V] = parent_U;
            rank[parent_U]++;
        }
    }
}

public class G46UnionByRank {

    public static void main(String[] args) {

        DisjointSetByRank ds=new DisjointSetByRank(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
        if(ds.findParent(3)==ds.findParent(7))
            System.out.println("Same");
        else
            System.out.println("Not same");
        ds.unionByRank(3,7);

        if(ds.findParent(3)==ds.findParent(7))
            System.out.println("Same");
        else
            System.out.println("Not same");

        //Tc:log(4 alpha) for findParent +log(4 alpha) for union
        //SC:O(n) rank and +o(N) parent
    }
}
