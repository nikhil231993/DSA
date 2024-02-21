package leetcode.stack.easy;

import java.util.Stack;

public class NextGreater {

    public static void main(String[] args) {

        int[] nums=new int[]{1,8,7,4,5,6,3,29,90};

        findNextGreater(nums);
        for(int n:nums)
            System.out.println(n);
    }

    private static void findNextGreater(int[] nums) {

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<nums.length;i++){
            while (!st.isEmpty() && nums[st.peek()]<nums[i]){
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
