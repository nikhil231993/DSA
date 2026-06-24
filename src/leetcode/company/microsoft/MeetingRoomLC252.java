package leetcode.company.microsoft;

import java.util.Arrays;

public class MeetingRoomLC252 {

    public static void main(String[] args) {
       int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        System.out.println(canAttendMeetings(intervals));
    }

    private static boolean canAttendMeetings(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        for(int i=1;i<n;i++){
            if(intervals[i-1][1]>intervals[i][0])
                return false;
        }
        return true;
        //TC:O(nlogn)
    }
}
