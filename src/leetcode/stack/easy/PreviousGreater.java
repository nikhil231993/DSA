package leetcode.stack.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PreviousGreater {

    public static void main(String[] args) {

        int[] nums=new int[]{4,6,2,3,9,10,70,188,59,92};

        Stack<Integer> st=new Stack<>();

        //Approach 1: Two for loops and n square

        //Approach 2:
        previousGreater(nums,st);
        for(int n:nums)
            System.out.println(n);
    }

    private static void previousGreater(int[] nums, Stack<Integer> st) {

        for(int i=nums.length-1; i>=0; i--){
			while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int index=st.pop();
                nums[index]=nums[i];
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            nums[st.pop()] = -1;
        }

        //TC:O(N + N)
        //SC:O(N) worst case if it is an decreasing array
    }

    private static ArrayList<Integer> preGreaterEle(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int i=n-1;
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(n, -1));
        while(i>=0){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                list.set(st.pop(), arr[i]);
            }
            st.push(i);
            i--;
        }

        while(!st.isEmpty())
            list.set(st.pop(), -1);

        return list;
    }
}
