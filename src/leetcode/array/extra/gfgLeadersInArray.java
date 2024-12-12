package leetcode.array.extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class gfgLeadersInArray {

   public static void main(String[] args) {

        int[] num=new int[]{16, 17, 4, 3,5, 2};

        //Approach 1
        List<Integer> result=leaders(num);
        for(int n:result)
            System.out.println(n);

        System.out.println("################");

        //Approach 2: no improvement but we can do using stack
        List<Integer> result1=leadersUsingStack(num);
        for(int n:result1)
            System.out.println(n);
    }

    private static List<Integer> leadersUsingStack(int[] arr) {

        Stack<Integer> st=new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            if(st.isEmpty() || st.peek() <= arr[i]){
                st.push(arr[i]);
            }
        }

        List<Integer> list=new ArrayList<>();
        while(!st.isEmpty())
            list.add(st.pop());

        return list;
    }

    private static List<Integer> leaders(int[] num) {

        int n=num.length;
        List<Integer> ans=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=n-1;i>0;i--){
            if(num[i]>max)
                ans.add(0,num[i]); // add at 0 adds all the element at first or else we have to reverse it
            max=Math.max(max,num[i]);
        }
        return ans;
        //TC:O(N)
        //SC:(1) as we are not using anything to find the answer. We are using ans to only store the values
    }
}
