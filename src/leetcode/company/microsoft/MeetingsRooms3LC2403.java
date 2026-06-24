package leetcode.company.microsoft;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingsRooms3LC2403 {

    public static void main(String[] args) {
        int n = 2;
        int[][] meetings =new int[][] {{0,10},{1,5},{2,7},{3,4}};
        System.out.println(mostBooked(n, meetings));
    }

    public static int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b)->a[0]-b[0]);
        int m=meetings.length;
        PriorityQueue<Integer> freeRooms= new PriorityQueue<>();
        PriorityQueue<long[]> busyRooms= new PriorityQueue<>(
                (a,b)->a[0]==b[0]?Long.compare(a[1], b[1]):Long.compare(a[0], b[0])
        );

        for(int i=0;i<n;i++)
            freeRooms.offer(i);
        int[] count=new int[n];

        for(int i=0;i<m;i++){

            int start=meetings[i][0];
            int end=meetings[i][1];

            while(!busyRooms.isEmpty() && busyRooms.peek()[0]<=start){
                long[] meetingCompleteRoom=busyRooms.poll();
                freeRooms.offer((int)meetingCompleteRoom[1]);
            }

            if(!freeRooms.isEmpty()){
                long freeRoom=freeRooms.poll();
                busyRooms.offer(new long[]{end, freeRoom});
                count[(int)freeRoom]++;
            }else{

                long[] recentavailableMeetingRoom=busyRooms.poll();
                int room=(int)recentavailableMeetingRoom[1];
                long nextMeetingDurationEnd=recentavailableMeetingRoom[0]+(end-start);
                busyRooms.offer(new long[]{nextMeetingDurationEnd, room});
                count[room]++;
            }
        }

        int maxCount=0, index=0;
        for(int i=0;i<n;i++){
            if(count[i]>maxCount){
                maxCount=count[i];
                index=i;
            }
        }
        return index;
    }
}
