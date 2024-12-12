package leetcode.array.medium;

public class LC167TwoSum2SortedArray {

	public static void main(String[] args) {

		int[] nums = new int[] { 2, 3, 4 };
		int target = 6;

		int[] arr = sum(nums, target);
		for (int n : arr)
			System.out.println(n);
	}

	private static int[] sum(int[] nums, int target) {

		int i = 0;
		int j = nums.length - 1;
		
		while(i<j) {
			if(nums[i]+nums[j]==target)
				return new int[] { i + 1, j + 1 };
			else if (nums[i] + nums[j] > target)
				j--;
			else
				i++;
		}
		return new int[] {};

		// SC:O(1)
		// TC:O(n)
	}
}
