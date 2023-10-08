package leetcode.graph.medium;

import java.sql.SQLOutput;

class DisjointSet{

    public int[] parent=null;
    public int[] rank=null;

    public DisjointSet(int n){
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
        }
    }

    public int findParent(int u){
        if(u==parent[u])
            return u;
        return parent[u]=findParent(parent[u]);
    }

    public void union(int u, int v){
        int parentU=findParent(u);
        int parentV=findParent(v);

        if(parentU==parentV)
            return;
        int rankU=rank[parentU];
        int rankV=rank[parentV];

        if(rankU<rankV)
            parent[parentU]=parentV;
        else if(rankV<rankU)
            parent[parentV]=parentU;
        else{
            parent[parentV]=parentU;
            rank[parentU]++;
        }

    }
}
public class LC684RedunantConnection {
    public static void main(String[] args) {
        int[][] edges = new int[][] {{1,2},{1,3},{2,3}};

        int[] r=findRedundantConnection(edges);
        System.out.println("Redundant edge is: ");
        if(r.length==0)
            System.out.println("No redundant edge");
        for(int n:r)
            System.out.println(n);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DisjointSet ds=new DisjointSet(n);

        for(int[] row:edges){
            if(ds.findParent(row[0])==ds.findParent(row[1]))
                return new int[]{row[0],row[1]};
            else
                ds.union(row[0],row[1]);
        }
        return new int[]{};
    }
}
