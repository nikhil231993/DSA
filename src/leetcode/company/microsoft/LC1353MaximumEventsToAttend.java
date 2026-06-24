package leetcode.company.microsoft;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1353MaximumEventsToAttend {

    public static void main(String[] args) {

        int[][] events= new int [][]{{1,2},{2,3},{3,4},{1,2}};
        System.out.println(maxEvents(events));
    }

    private static int maxEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events, (a, b)->a[0]-b[0]);

        int maxDay=0;
        for(int i=0;i<n;i++)
            maxDay=Math.max(maxDay, events[i][1]);

        int count=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        int i=0;
        for(int day=1;day<=maxDay;day++){

            while(i<n && events[i][0]==day){
                minHeap.offer(events[i][1]);
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()<day)
                minHeap.poll();
            if(!minHeap.isEmpty()){
                minHeap.poll();
                count++;
            }
        }
        return count;
    }
}