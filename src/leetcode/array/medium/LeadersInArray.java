package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {

    public static void main(String[] args) {

        int[] num=new int[]{10,22,12,3,0,6};
        List<Integer> result=leaders(num);
        for(int n:result)
            System.out.println(n);
    }

    private static List<Integer> leaders(int[] num) {
        int n=num.length;
        List<Integer> ans=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>0;i--){
            if(num[i]>max)
                ans.add(num[i]);
            max=Math.max(max,num[i]);
        }
        return ans;
        //TC:O(N)
        //SC:(1) as we are not using anything to find the answer. We are using ans to only store the values
    }
}
