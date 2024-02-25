package leetcode.stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class LC503NextGreaterElement2 {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3, 4, 3 };
		int[] result = nextGreaterElements(nums);

		for (int n : result)
			System.out.println(n);
	}

	public static int[] nextGreaterElements(int[] nums) {

		Stack<Integer> st = new Stack();

		int[] ans = new int[nums.length];
		Arrays.fill(ans, -1);

		for (int i = 0; i < nums.length * 2; i++) {

			while (!st.isEmpty() && nums[st.peek()] < nums[i % nums.length]) {
				ans[st.pop()] = nums[i % nums.length];
			}
			st.push(i % nums.length);
		}
		return ans;
	}
}
