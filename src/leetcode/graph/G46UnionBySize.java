package leetcode.graph;

class DisjointSetBySize{

    protected int[] parent=null;
    protected int[] size=null;

    public DisjointSetBySize(int n){

        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
            size[i]=1;// As all the nodes are component of itself
            parent[i]=i;
        }
    }

    public int findParent(int node){

        if(node ==parent[node])
            return node;
        return parent[node]=findParent(parent[node]);
    }

    public void unionBySize(int u,int v){

        int parent_U = findParent(u);
        int parent_V = findParent(v);

        //Don't do anything as both have same parent and by path compression they would be directly pointing to parent
        if(parent_U == parent_V) return;

        int size_U = size[parent_U];
        int size_V = size[parent_V];

        if(size_U < size_V){
            parent[parent_U] = parent_V;
            size[parent_V] += size[parent_U];
        }else if(size_V < size_U){
            parent[parent_V] = parent_U;
            size[parent_U] += size[parent_V];
        }else{
            parent[parent_U]=parent_V;
            size[parent_V]+=size[parent_U];
        }
    }
}

public class G46UnionBySize {

    public static void main(String[] args) {

        DisjointSetBySize ds=new DisjointSetBySize(7);
        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(6,7);
        ds.unionBySize(5,6);
        if(ds.findParent(3)==ds.findParent(7))
            System.out.println("Same");
        else
            System.out.println("Not same");
        ds.unionBySize(3,7);

        if(ds.findParent(3)==ds.findParent(7))
            System.out.println("Same");
        else
            System.out.println("Not same");

        //TC:O(4 alpha) for findParent + O(4 alpha) for union
        //SC:O(n) rank and +o(N) parent
    }
}
