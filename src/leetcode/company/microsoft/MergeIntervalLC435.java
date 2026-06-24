package leetcode.company.microsoft;

import java.util.Arrays;

public class MergeIntervalLC435 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a, b)->(a[1]- b[1]));
        int count=1, prevEnd=intervals[0][1];

        for(int i=1;i<n;i++){
            if(intervals[i][0]>=prevEnd){
                count++;
                prevEnd=intervals[i][1];
            }
        }
        return n-count;
    }
}
