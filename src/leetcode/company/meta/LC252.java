package leetcode.company.meta;

import java.util.Arrays;

public class LC252 {

    public static void main(String[] args) {

        int[][] intervals=new int[][]{{7,10},{2,4}};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {

        int n=intervals.length;
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        for(int i=0;i<n-1;i++){
            if(intervals[i][1]>intervals[i+1][0])
                return false;
        }
        return true;
    }
}
