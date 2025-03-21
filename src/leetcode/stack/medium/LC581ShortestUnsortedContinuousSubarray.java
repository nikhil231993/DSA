package leetcode.stack.medium;

import java.util.Stack;

public class LC581ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {

       int[] nums =new int[] {1,5,2,4,6};
       nums=new int[]{2, 6, 4, 8, 10, 9,15};
       System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {

        int n=nums.length;
        Stack<Integer> st1=new Stack();
        Stack<Integer> st2=new Stack();

        //first smaller which is basically next smaller algo
        int leftIndex=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){

            while(!st1.isEmpty() && nums[st1.peek()]>nums[i]){
                leftIndex=Math.min(leftIndex, st1.peek());
                st1.pop();
            }
            st1.push(i);
        }

        //first previous greater which previous greater
        int rightIndex=Integer.MIN_VALUE;
        for(int i=n-1; i>=0; i--){

            while(!st2.isEmpty() && nums[st2.peek()]<nums[i]){
                rightIndex=Math.max(rightIndex, st2.peek());
                st2.pop();
            }
            st2.push(i);
        }

        if(leftIndex==Integer.MAX_VALUE && rightIndex==Integer.MIN_VALUE)
            return 0;

        return rightIndex - leftIndex + 1;

        //TC: O(2*n) parsing array two times
        //SC: O(2*n) two stack space in worst case
    }
}
