package leetcode.stack.easy;

import java.util.Stack;

public class NextGreater {

    public static void main(String[] args) {

        int[] nums=new int[]{1,8,7,4,5,6,3,29,90};

        Stack<Integer> st=new Stack<>();

        //Approach 1 : Brute force with TC :O(n square)

        //Approach 2:
        findNextGreater(nums, st);
        for(int n:nums)
            System.out.println(n);
    }

    private static void findNextGreater(int[] nums, Stack<Integer> st) {

        for(int i=0; i<nums.length; i++){
            while (!st.isEmpty() && nums[st.peek()] < nums[i]){
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
}
