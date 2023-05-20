package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class LC1042McolouringGfg {

    public static void main(String[] args) {
        int N = 4;
        int M = 3;
        int E = 5;
        int[][] edges =new int[][] {{0,1},{1,2},{2,3},{3,0},{0,2}};

        //Create Adjacency List
        List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<N;i++)
            adjList.add(new ArrayList<>());

        for(int[] r:edges){
            adjList.get(r[0]).add(r[1]);
            adjList.get(r[1]).add(r[0]);
        }
        int[] color=new int[N];

        System.out.println(isGraphColouring(adjList,N,M,E,0,color));

        //TC:m raise to N
        //Video complexity is wrong
        //SC:o(N) recursion stack+O(N)color array

    }

    private static boolean isGraphColouring(List<List<Integer>> adjList, int n, int m, int e, int node,int[] color) {

        if(node==n)
            return true;

        for(int i=1;i<=m;i++){
            if(isSafe(node,adjList,m,e,color,i)){
                color[node]=i;
                if(isGraphColouring(adjList,n,m,e,node+1,color)){
                    return true;
                }
                color[node]=0;

            }
        }
        return false;
    }

    private static boolean isSafe(int node, List<List<Integer>> adjList, int m, int e, int[] color,int i) {

        for(Integer vertex:adjList.get(node)){
            if(color[vertex]==i)
                return false;
        }
        return true;
    }
}
