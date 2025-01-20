package leetcode.array.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LC560SubarraySum {

	public static void main(String[] args) {

		int[] nums = new int[] { 4, 5, 1, 3, 2, 3, 4 };
		int k = 9;

		//Approach 1: 3 loops

		//Approach 2: Better
		System.out.println(subarraySum(nums, k));

		//Approach 3:Optimal
		System.out.println(subarraySumOptimal(nums, k));
	}

	public static int subarraySum(int[] nums, int k) {

		 int n = nums.length;
		 int count = 0;
		 for (int i = 0; i < n; i++) {
			 int sum =0;
			 for (int j = i; j < n; j++) {
				 sum = sum+nums[j];
				 if(sum ==k) {
					 count++;
				 }
			 }
		 }
		 return count;

		 //TC:O(n square)
		 //SC:O(1)
	}

	public static int subarraySumOptimal(int[] nums, int k) {

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
			m.put(sum, m.getOrDefault(sum,0) + 1);
		}
		return count;

		//TC:O(n)
		//SC:O(n)
	}
}
