package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LC560SubarraySum {

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 1, 3, 2, 3, 4 };
		int k = 9;
		System.out.println(subarraySum(nums, k));

	}

//	public static int subarraySum(int[] nums, int k) {
//		int j = 0;
//		int sum = 0;
//		int count = 0;
//		for (int i = 0; i < nums.length; i++) {
//			if (sum + nums[i] < k) {
//				sum += nums[i];
//				continue;
//			} else if (sum + nums[i] == k) {
//				count++;
//				sum = 0;
//				i = j;
//				j++;
//			} else {
//				i = j;
//				sum = 0;
//				j++;
//			}
//		}
//		return count;
//
//	}

	public static int subarraySum(int[] nums, int k) {
		int sum = 0;
		int count = 0;
		HashMap<Integer, Integer> m = new LinkedHashMap<>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) {
				count++;
        }
			if (m.containsKey(sum - k)) {
				count += m.get(sum - k);
			}
			if (m.containsKey(sum))
				m.put(sum, m.get(sum) + 1);
			else
				m.put(sum, 1);

		}
		return count;
	}
}
