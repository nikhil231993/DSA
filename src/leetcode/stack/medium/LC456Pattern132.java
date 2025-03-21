package leetcode.stack.medium;

import java.util.Stack;

public class LC456Pattern132 {

    public static void main(String[] args) {

        int[] nums = new int[] {9,4,2,8,3,1,2};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {

        //Step 1: Create a max stack .ie. max element should be at the top of the stack
        //Step 2: whenever a smaller element is removed save that as secondMax
        //step 3: when new element comes up, check if it is smaller than the secondMax. If yes then that is the answer

        int secondMax=Integer.MIN_VALUE;
        Stack<Integer> maxStack=new Stack<>();
        int n=nums.length;
        for(int i=n-1; i>=0; i--){

            if(nums[i]<secondMax)
                return true;
            while (!maxStack.isEmpty() && nums[maxStack.peek()]<nums[i]){
                secondMax=Math.max(secondMax, nums[maxStack.pop()]);
            }
            maxStack.push(i);
        }
        return false;

        //TC:O(n)
        //SC:O(n)
    }
}
