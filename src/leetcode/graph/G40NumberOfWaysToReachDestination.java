package leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class PairG40{

    protected int node;
    protected long distance;

    public PairG40(int node,long distance){
        this.node=node;
        this.distance=distance;

    }
}

public class G40NumberOfWaysToReachDestination {

    //converting to long as the test case in leetcode have large values
    public static void main(String[] args) {

        int V = 7;
        int[][] roads =new int[][] {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(countPaths(V,roads));

        //TC:ElogV
        //SC:O(N) queue+ O(N) distance +O(N) ways
    }

    public static int countPaths(int n, int[][] roads) {

        List<List<PairG40>> adList=new ArrayList<>();

        for(int i=0;i<n;i++){
            adList.add(new ArrayList<>());
        }

        for(int i=0;i<roads.length;i++){
            //Since its bi-directional
            adList.get(roads[i][0]).add(new PairG40(roads[i][1],roads[i][2]));
            adList.get(roads[i][1]).add(new PairG40(roads[i][0],roads[i][2]));
        }

        long[] distance=new long[n];
        Arrays.fill(distance,(int)(1e18));
        distance[0]=0;

        long[] ways=new long[n]; // we use long hear because time constraint is <=10 raise to 9 in leetcode so the value can be beyond integer range
        Arrays.fill(ways,0);
        ways[0]=1;
        int mod=(int)(1e9+7);

        PriorityQueue<PairG40> pq=new PriorityQueue<>((a,b)-> Long.compare(a.distance,b.distance));
        pq.offer(new PairG40(   0,0));

        while (!pq.isEmpty()){
            long dis=pq.peek().distance;
            int node=pq.peek().node;
            pq.poll();

            for(PairG40 vertexPair:adList.get(node)){
                int vert=vertexPair.node;
                long vertDistance=vertexPair.distance;

                if(vertDistance+dis < distance[vert]){
                    distance[vert]=vertDistance+dis;
                    pq.offer(new PairG40(vert,vertDistance+dis));
                    ways[vert] = ways[node] % mod;
                }else if(vertDistance+dis==distance[vert]){
                    ways[vert]=(ways[vert]+ways[node]) % mod;
                }
            }
        }
        return (int)ways[n-1]%mod;
    }
}
