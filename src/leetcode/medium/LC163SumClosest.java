package leetcode.medium;

import java.util.Arrays;

public class LC163SumClosest {

	public static void main(String[] args) {
		int target = 1;
		int[] nums = new int[] { -1, 2, 1, -4 };
		System.out.println(closesetSum(target, nums));

	}

	private static int closesetSum(int target, int[] nums) {
		Arrays.sort(nums);// O(nlogn)
		int diff=Integer.MAX_VALUE;
		int ans=0;
		for (int i = 0; i < nums.length; i++) {
			int first = nums[i];
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				if (first + nums[start] + nums[end] == target)
					return target;

				if (Math.abs(first + nums[start] + nums[end] - target) < diff) {
					diff = Math.abs(first + nums[start] + nums[end] - target);
					ans = first + nums[start] + nums[end];
				}

				if (first + nums[start] + nums[end] < target)
					start++;
				else
					end--;

			}
		}

		// SC:O(1)
		// TC:O(n2)
		return ans;
	}

}
