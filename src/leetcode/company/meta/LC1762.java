package leetcode.company.meta;

import java.util.ArrayList;
import java.util.List;

public class LC1762 {

    public static void main(String[] args) {

        int[] heights =new int[] {4,2,3,1};
        System.out.println(findBuildings(heights));
    }

    public static int[] findBuildings(int[] heights) {

        int n=heights.length;
        List<Integer> list=new ArrayList();
        if(n==0)
            return new int[]{};
        list.add(n-1);
        int max=heights[n-1];
        for(int i=n-2;i>=0;i--){
            if(heights[i]>max){
                list.add(0,i);
                max=heights[i];
            }
        }
        return list.stream().mapToInt(a->a).toArray();
    }
}
