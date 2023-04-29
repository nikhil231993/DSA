package leetcode.stack;

import java.util.Stack;

public class PreviousSmaller {

    public static void main(String[] args) {
        int[] nums=new int[]{1,5,3,4,6,7,2,8,9};
        Stack<Integer> st=new Stack<>();
        findPrevMinimumOfEachElement(nums,st);
        for(int n: nums)
            System.out.println(n);
    }

    private static void findPrevMinimumOfEachElement(int[] nums, Stack<Integer> st) {

        for(int i=nums.length-1;i>=0;i--){
            while (!st.isEmpty() && nums[st.peek()]>nums[i] ){
                int index=st.pop();
                nums[index]=nums[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()){
            nums[st.pop()]=-1;
        }
    }
}
