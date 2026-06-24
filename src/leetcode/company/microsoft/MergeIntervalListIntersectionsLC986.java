package leetcode.company.microsoft;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MergeIntervalListIntersectionsLC986 {

    public static void main(String[] args) {
        int[][] firstList = new int[][] {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = new int[][] {{1,5},{8,12},{15,24},{25,26}};
        int[][] result=intervalIntersection(firstList, secondList);
        for(int[] r: result)
            System.out.println(r[0] + " " + r[1]);
    }

    private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n=firstList.length;
        int m=secondList.length;

        int firstIndex=0, secondIndex=0;
        int start=0, end=0;
        List<int[]> list=new ArrayList<>();
        while(firstIndex<n && secondIndex<m){
            start=Math.max(firstList[firstIndex][0], secondList[secondIndex][0]);
            end=Math.min(firstList[firstIndex][1], secondList[secondIndex][1]);

            if(start<=end){
                list.add(new int[]{start, end});
            }

            if(firstList[firstIndex][1]==end)
                firstIndex++;
            else if(secondList[secondIndex][1]==end)
                secondIndex++;
        }
        return list.toArray(new int[0][]);
    }
}
