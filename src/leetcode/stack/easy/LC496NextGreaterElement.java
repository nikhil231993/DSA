package leetcode.stack.easy;

import java.util.HashMap;
import java.util.Stack;

public class LC496NextGreaterElement {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 3, 5, 2, 4 };
		int[] nums2 = new int[] { 6, 5, 4, 3, 2, 1, 7 };
	
		int[] arr = nextGreaterElement(nums1, nums2);

		for (int x : arr)
			System.out.println(x);

	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> map = new HashMap();
		Stack<Integer> stack = new Stack();
		for (int i = nums2.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
				stack.pop();
			}
			int res = 0;
			if (stack.isEmpty()) {
				res = -1;
			} else {
				res = stack.peek();
			}

			map.put(nums2[i], res);
			stack.push(nums2[i]);
		}
		int[] arr = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			arr[i] = map.get(nums1[i]);
		}
		return arr;

	}

}
