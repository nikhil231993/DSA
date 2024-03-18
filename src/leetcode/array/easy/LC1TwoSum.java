package leetcode.array.easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC1TwoSum {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 22;

		//Approach 1 brute
		int[] r = twoSum(nums, target);
		for (int n : r)
			System.out.println(n);
		System.out.println("###############");

		//Approach 2 better
		int[] r1= twoSumUsingMap(nums, target);
		for (int n : r1)
			System.out.println(n);
		System.out.println("###############");

		//Approach 3 Optimal
		int[] r2 = twoSumBestApproach(nums, target);
		for (int n : r2)
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

	// Best Approach
	private static int[] twoSumBestApproach(int[] nums, int target) {
		int[] result = new int[2];
		int d = 1;
		int t1 = 0;
		int t2 = 1;
		while (true) {
			if (nums[t1] + nums[t2] == target) {
				result[0] = t1;
				result[1] = t2;
				break;
			} else if (t2 == nums.length - 1) {
				d++;
				t1 = 0;
				t2 = d;
			} else {
				t1++;
				t2++;
			}
		}
		return result;

		// SC:O(1)
		// TC:O(greater than n  but less than n square)
	}
}
