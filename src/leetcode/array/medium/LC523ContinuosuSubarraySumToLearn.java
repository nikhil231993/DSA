package leetcode.array.medium;

public class LC523ContinuosuSubarraySumToLearn {

	public static void main(String[] args) {
		int[] nums = new int[] { 23, 2, 4, 6, 6 };
		int k = 7;

		System.out.println(checkSubarraySum(nums, k));

	}

	public static boolean checkSubarraySum(int[] nums, int k) {
		int j = 0;
		int len = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum < k) {
				len++;
			} else if (sum / k == 0 && len >= 2) {
				len = 0;
				sum = 0;
				i = j;
				j++;
				return true;
			} else if (i == nums.length - 1) {
				i = j;
			sum = 0;
			j++;
			len=0;
			}
		}
		return false;

	}

}
