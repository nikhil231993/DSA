package leetcode.easy.array;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC1TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 9;

		// int[] r = twoSum(nums, target);
		int[] r = twoSumUsingMap(nums, target);

		for (int n : r)
			System.out.println(n);

	}

	private static int[] twoSumUsingMap(int[] nums, int target) {
		Map<Integer, Integer> map = new LinkedHashMap();
		for(int i=0;i<nums.length;i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			map.put(nums[i], i);
		}
		return new int[] {};
		// SC:O(n)
		// TC:O(n)
	}

	private static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}

		}
		return new int[] {};

		// SC:O(1)
		// TC:O(n2)
	}

}
