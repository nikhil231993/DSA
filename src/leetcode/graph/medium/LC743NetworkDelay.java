package leetcode.graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair{
    int time;
    int node;

    public Pair(int node,int time){
        this.time=time;
        this.node=node;
    }
}
public class LC743NetworkDelay {

    public static void main(String[] args) {
        int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times,n,k));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        List<List<Pair>> adjList=new ArrayList();

        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList());
        }

        for(int[] r:times){
            int node=r[0];
            int adjNode=r[1];
            int time=r[2];
            adjList.get(node).add(new Pair(adjNode, time));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b)->(a.time-b.time));
        pq.offer(new Pair(k,0));
        int[] dist=new int[n+1];
        Arrays.fill(dist,(int)(1e9));
        dist[k]=0;
        int maxTime=Integer.MIN_VALUE;;
        while(!pq.isEmpty()){
            Integer node=pq.peek().node;
            Integer tim=pq.peek().time;
            pq.poll();

            for(Pair p:adjList.get(node)){
                Integer vertex=p.node;
                Integer dis=p.time;

                if(dist[vertex]>dis+tim){
                    dist[vertex]=dis+tim;
                    pq.offer(new Pair(vertex,dist[vertex]));
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(dist[i]==(int)(1e9))
                return -1;
            maxTime=Math.max(maxTime,dist[i]);
        }
        return maxTime;

    }
}
