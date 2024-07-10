package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC973KClosestPointsToOrigin {

    public static void main(String[] args) {

        int[][] points =new int[][] {{3,3},{5,-1},{-2,4}};
        int k = 2;

        int[][] result=kClosest(points,k);

        for(int[] r: result)
            System.out.println(r[0]+" "+r[1]);
    }

    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(((b[0]-0)*(b[0]-0))+(b[1]-0)*(b[1]-0))-((a[0]-0)*(a[0]-0)+(a[1]-0)*(a[1]-0)));

        for(int[] arr:points){

            pq.offer(new int[]{arr[0],arr[1]});
            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] result=new int[pq.size()][];

        int i=0;
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            result[i++]=temp;
        }
        return result;

        //TC:n log k
        //SC:K
    }
}
