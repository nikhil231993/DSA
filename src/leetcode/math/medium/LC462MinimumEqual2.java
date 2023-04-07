package leetcode.math.medium;

import java.util.Arrays;

public class LC462MinimumEqual2 {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 3, 7, 8, 11 };

		// Best approach
		System.out.println(minMoves(num));
	}

	public static int minMoves(int[] nums) {

		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int minMoves = 0;
		while (left < right) {
			minMoves += Math.abs(nums[left++] - nums[right--]);
		}
		return minMoves;
		// SC:O(1)
		// TC:O(nlogn)

	}

}
