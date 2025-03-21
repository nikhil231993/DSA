package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC973KClosestPointsToOrigin {

    public static void main(String[] args) {

        int[][] points =new int[][] {{3,3},{5,-1},{-2,4}};
        points=new int[][]{{-5,4}, {-6,-5},{4,6}};
        int k = 2;

        int[][] result = kClosest(points,k);

        for(int[] r: result)
            System.out.println(r[0]+" "+r[1]);
    }

    public static int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(((b[0]-0)*(b[0]-0))+(b[1]-0)*(b[1]-0)) - ((a[0]-0)*(a[0]-0)+(a[1]-0)*(a[1]-0)));

        for(int[] arr:points){

            pq.offer(new int[]{arr[0], arr[1]});
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

    //Approach 2: There is no approach diff only the way diff is calculated is different

    /**
    class Node{
        int row;
        int dist;
        public Node(int row, int dist){
            this.row=row;
            this.dist=dist;
        }
    }

    class Solution {
        public int[][] kClosest(int[][] points, int k) {

            int n = points.length;
            PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->b.dist-a.dist);
            for(int i=0; i<n; i++){
                pq.offer(new Node(i, dist(points[i][0], points[i][1])));
                if(pq.size()>k)
                    pq.poll();
            }

            int[][] result=new int[k][];
            int i=0;
            while(!pq.isEmpty()){
                Node n1=pq.poll();
                result[i++]=new int[]{points[n1.row][0], points[n1.row][1]};
            }
            return result;

        }

        public static int dist(int x, int y){
            return (x*x) + (y*y);
        }
    }
     */
}
