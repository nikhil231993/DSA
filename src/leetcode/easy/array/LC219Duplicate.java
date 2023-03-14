package leetcode.easy.array;

import java.util.HashMap;

public class LC219Duplicate {
	public static void main(String[] args) {

		int[] nums = new int[] { 1, 0, 1, 1 };

		int k = 1;

		System.out.println(containsNearbyDuplicate(nums, k));

	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(nums[i])) {
				int diff = i - map.get(nums[i]);
				if (diff <= k)
					return true;
			}
			map.put(nums[i], i);
		}
		return false;

	}

}
