package leetcode.stack.easy;

import java.util.HashMap;
import java.util.Map;
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

		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < nums2.length; i++) {
			while (!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
				map.put(nums2[st.pop()], nums2[i]);
			}
			st.push(i);
		}
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			result[i] = map.getOrDefault(nums1[i], -1);
		}
		return result;
	}
}
