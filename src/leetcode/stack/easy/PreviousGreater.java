package leetcode.stack.easy;

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
            nums[st.pop()]=-1;
        }

        //TC:O(N + N)
        //SC:O(N) worst case if it is an increasing array
    }
}
