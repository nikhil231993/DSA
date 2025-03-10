package leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class PairG39{

     protected int level;
     protected int node;

     public PairG39(int level, int node){
         this.level=level;
         this.node=node;

     }
 }

public class G39MinimumMultiplicationToReachEnd {

    public static void main(String[] args) {

        int[] arr=new int[]{9,12,18,19};
        int start=5;
        int end=5;

        //Both gave correct ans in GFG
        //TC: O(10000 * size of array) we cannot say a correct value as it depends on mod and arr size
        //SC: O(N) queue+O(N) distance
        System.out.println(minimumMultiplications(arr,start,end));

        //SC:O(N) queue + O(N) visited
        System.out.println(minimumMultiplicationsWithoutUsingDistanceArray(arr,start,end));
    }

    public static int minimumMultiplications(int[] arr, int start,int end){

        if(start==end) return 0;

        int mod=100000;
        Queue<PairG39> q=new LinkedList<>();
        q.offer(new PairG39(0,start));
        int[] dist=new int[mod];
        dist[start]=0;

        Arrays.fill(dist,(int)(1e9));

        while (!q.isEmpty()){
            Integer level=q.peek().level;
            Integer node=q.peek().node;
            q.poll();

            for(Integer n: arr){
               Integer vertex=(n*node)%mod;

               if(vertex==end)
                   return level+1;
               if(dist[vertex] > level + 1){
                   dist[vertex] = level + 1;
                   q.offer( new PairG39(level+1,vertex));
               }
            }
        }
        return -1;
    }

    public static int minimumMultiplicationsWithoutUsingDistanceArray(int[] arr, int start, int end) {

        if(start==end) return 0;

        //Since it levels up by 1 we do not need a distance array
        int mod=100000;
        Queue<PairG39> q=new LinkedList<>();
        q.offer(new PairG39(0,start));

        int[] visited=new int[mod];
        visited[start]=1;

        while (!q.isEmpty()){
            Integer level=q.peek().level;
            Integer node=q.peek().node;
            q.poll();

            for(Integer n: arr){
                Integer vertex=(n*node)%mod;
                if(visited[vertex]==1)
                    continue;
                visited[vertex]=1; // Since the level move by 1, once we reach an element we will not reach it in future
                //in better time complexity
                if(vertex==end)
                    return level+1;
                q.offer(new PairG39(level+1, vertex));
            }
        }
        return -1;
    }
}
