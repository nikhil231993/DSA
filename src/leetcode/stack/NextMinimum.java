package leetcode.stack;

import java.util.Stack;

public class NextMinimum {

    public static void main(String[] args) {
        int[] nums=new int[]{1,5,3,4,6,7,2,8,9};
        Stack<Integer> st=new Stack<>();
        findNextMinimumOfEachElement(nums,st);
        for(int i=0;i<nums.length;i++)
            System.out.println(nums[i]);

    }

    private static void findNextMinimumOfEachElement(int[] nums, Stack<Integer> st) {

        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                int index=st.pop();
                nums[index]=nums[i];
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            nums[st.pop()]=-1;
        }
    }
}
