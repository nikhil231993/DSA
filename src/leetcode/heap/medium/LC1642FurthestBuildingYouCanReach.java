package leetcode.heap.medium;

import java.util.PriorityQueue;

public class LC1642FurthestBuildingYouCanReach {

    public static void main(String[] args) {

        int[] heights = new int[]{4,2,7,6,9,14,12};
        int bricks = 5, ladders = 1;
        System.out.println(furthestBuilding(heights,bricks,ladders));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq=new PriorityQueue();

        for(int i=0;i < heights.length-1; i++){
            int gap=heights[i+1]-heights[i];
            if(gap>0)
                pq.offer(gap);
            if(pq.size()>ladders){
                bricks-=pq.poll();
            }

            if(bricks<0)
                return i;
        }
        return heights.length-1;

        //TC:(ladders log ladders)
        //SC:O(ladders)
    }
}
