package leetcode.company.microsoft;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomLC253 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRoomsBestApproach(intervals));

        int[][] intervals1 = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(minMeetingRoomsApproach2(intervals1));

    }

    private static int minMeetingRoomsApproach2(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int n=intervals.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(intervals[0][1]);
        for(int i=1;i<n;i++){
            if(pq.peek()<=intervals[i][0])
                pq.poll();
            pq.offer(intervals[i][1]);
        }
        return pq.size();
    }

    private static int minMeetingRoomsBestApproach(int[][] intervals) {
         int n = intervals.length;
         int[] start = new int[n];
         int[] end = new int[n];
         for (int i = 0; i < n; i++) {
             start[i] = intervals[i][0];
             end[i] = intervals[i][1];
         }
         int count  = 0;
         int endIndex = 0;
         Arrays.sort(start);
         Arrays.sort(end);
         for (int i = 0; i< n; i++) {
             if (start[i] < end[endIndex]) {
                 count++;
             } else {
                 endIndex++;
             }
         }
         return count;
    }
}
