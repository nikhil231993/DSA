package leetcode.graph.medium;

import java.util.*;

public class LC868PossibleBipartition {

    public static void main(String[] args) {
       int n = 4;
       int[][] dislikes =new int[][] {{1,2},{1,3},{2,4}};
        System.out.println(possibleBipartition(n,dislikes));

    }
    public static boolean possibleBipartition(int n, int[][] dislikes) {

        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=n;i++)
            adjList.add(new ArrayList());

        for(int[] r:dislikes){
            adjList.get(r[0]).add(r[1]);
            adjList.get(r[1]).add(r[0]);
        }

        int[] color=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(bfs(color,i,adjList)==false)
                    return false;
            }
        }
        return true;

    }
    private static boolean bfs(int[] color,int i, List<List<Integer>> adjList) {

        color[i]=0;

        Queue<Integer> q=new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            Integer node=q.poll();

            for(Integer vertex: adjList.get(node)){
                if(color[vertex]==-1){
                    color[vertex]=1-color[node];
                    q.add(vertex);
                }else if(color[vertex]==color[node]){
                    return false;
                }
            }
        }
        return true;
        //TC:O(N+2E) while loop+O(N) outer for loop
        //SC:O(N) color array+O(N) queue
    }
}
