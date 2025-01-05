package leetcode.math.hard;

import java.util.HashMap;

public class LC149MaxPointsInLine {

    public static void main(String[] args) {

        int[][] points =new int[][] {{1,1},{2,2},{3,3}};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {

        double slope=0.0;
        int max=0;

        for(int[] point1:points){

            HashMap<Double, Integer> map=new HashMap<>(); //We need to reset map everytime or else the values will get added
            for(int[] point2: points){

                if(point1==point2)
                    continue;

                if(point1[0]==point2[0])
                    slope=Double.POSITIVE_INFINITY;
                else{
                    slope=((double)(point2[1]-point1[1])/(double)(point2[0]-point1[0]));
                }
                map.put(slope, map.getOrDefault(slope,0)+1);
                max=Math.max(map.get(slope),max);
            }
        }
        return max+1;

        //TC: O(n square)
        //SC: O(n square) in case all are different
    }
}
