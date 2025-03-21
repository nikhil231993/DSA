package leetcode.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class LC503NextGreaterElement2 {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 4, 3 };
		int[] result = nextGreaterElements(nums);

		for (int n : result)
			System.out.println(n);

		System.out.println("###########################");

		int[] result2 = nextGreaterElementsSelf(nums);
		// we cannot use Stack with while loop because  when we again go through it in 2*n cycle we will have last value 4 in place of 3 i.e. 2,3,4,0,4
		// which will lead to -1 in result. Debug and see the issue.

		for (int n : result2)
			System.out.println(n);
	}

	public static int[] nextGreaterElements(int[] nums) {

		Stack<Integer> st = new Stack();

		int[] ans = new int[nums.length];
		Arrays.fill(ans, -1);

		for (int i = 0; i<nums.length*2; i++) {

			while (!st.isEmpty() && nums[st.peek()] < nums[i % nums.length]) {
				ans[st.pop()] = nums[i % nums.length];
			}
			st.push(i % nums.length);
		}
		return ans;

		//TC:O(2 * n)
		//SC:O(2 * n)
	}

	public static int[] nextGreaterElementsSelf(int[] nums) {

		Stack<Integer> st=new Stack();
		int n=nums.length;
		int[] result=new int[n];

		for(int i=0; i< 2*n; i++){

			while(!st.isEmpty() && nums[st.peek()] < nums[i%n]){
				result[st.pop()]=nums[i%n];
			}
			st.push(i%n);
		}

		while(!st.isEmpty())
			result[st.pop()]=-1;
		return result;
	}
}
