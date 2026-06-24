package leetcode.company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervalLC57 {

    public static void main(String[] args) {

       int[][] intervals = new int[][] {{1,3},{6,9}};
       int[] newInterval = {2,5};
       int[][] result=insert(intervals, newInterval);
       for(int[] r: result)
           System.out.println(r[0] + " "+r[1]);
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> list=new ArrayList<>();
        int i=0;
        while(i<n && intervals[i][1]<newInterval[0]){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(new int[]{newInterval[0], newInterval[1]});
        while(i<n){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        return list.toArray(new int[0][]);
    }
}
