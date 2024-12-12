package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class LC1042FlowerPlanting {

        // we need not color with all four colours. If the colouring is possible we can return
    public static void main(String[] args) {
       int n = 3;
       int[][] paths =new int[][] {{1,2},{2,3},{3,1}};

       int [] result=gardenNoAdj(n,paths);
       for(int re:result)
           System.out.println(re);
    }

    public static  int[] gardenNoAdj(int n, int[][] paths) {

        //Creating the adjacency list
        List<List<Integer>> adjList=new ArrayList();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList());
        }

        for(int[] path: paths){
            adjList.get(path[0]-1).add(path[1]-1);
            adjList.get(path[1]-1).add(path[0]-1);
        }

        int[] color =new int[n];
        solveColoring(adjList, n, color, 0);
        return color;

    }
    public static boolean solveColoring(List<List<Integer>> adjList, int n, int[] color, int node){

        if(node==n)
            return true;
        for(int i=1; i<=4; i++){
            if(isSafe(i,node,color,adjList)){
                color[node]=i;
                if(solveColoring(adjList, n, color,node+1)){
                    return true;
                }
                color[node]=0;
            }
        }
        return false;
    }

    public static boolean isSafe(int i, int node, int[] color,List<List<Integer>> adjList){
        for(Integer vertex: adjList.get(node)){
            if(color[vertex]==i)
                return false;
        }
        return true;
        //TC:M raise to N
        //SC:O(N) recursion stack is equal to number of nodes
    }
}
