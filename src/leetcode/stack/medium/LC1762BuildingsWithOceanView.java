package leetcode.stack.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC1762BuildingsWithOceanView {

    public static void main(String[] args) {

        int[] heights = new int[]{4,2,3,1};

       int[] result=findBuildingsBrute(heights);
       for(int n1 : result)
           System.out.println(n1);

        System.out.println("************************");

       int[] result1=findBuildings(heights);
        for(int n1 : result1)
            System.out.println(n1);
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

    public static int[] findBuildingsBrute(int[] heights) {

        int n=heights.length;
        Stack<Integer> st=new Stack();
        for(int i=0;i<n;i++){

            while(!st.isEmpty() && heights[i]>=heights[st.peek()]){
                st.pop();
            }
            st.push(i);
        }

        int[] result=new int[st.size()];
        int i=result.length-1;
        while(!st.isEmpty()){
            result[i--]=st.pop();
        }
        return result;
    }
}
