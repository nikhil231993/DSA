package leetcode.TwoPointer.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC1610MaximumNumberOfVisiblePoints {

    public static void main(String[] args) {
       List<List<Integer>> points =new ArrayList<>();
       List<Integer> p1=new ArrayList<>(Arrays.asList(0,0));
       List<Integer> p2=new ArrayList<>(Arrays.asList(0,2));
          points.add(p1);
          points.add(p2);
        int angle = 90;
        List<Integer> location=new ArrayList<>(Arrays.asList(1,1));
        System.out.println(visiblePoints(points,angle,location));
    }

    public static int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int count = 0;
        for (List<Integer> p : points) {
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if (dx == 0 && dy == 0) { // edge case of same point
                count++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) * (180 / Math.PI));
        }
        Collections.sort(angles);
        List<Double> tmp = new ArrayList<>(angles);
         for (double d : angles) tmp.add(d + 360); // concatenate to handle edge case
        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + i - j + 1);
        }
        return res;
    }

}
