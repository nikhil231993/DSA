package leetcode.array.medium;

public class LC53MaxSubArrayKadane {

	public static void main(String[] args) {

		int[] arr = new int[] { 0, 1, 3, -5, 7 };

		//Approach 1: Brute
		System.out.println(maxSubArrayBrute(arr));

		//Approach 2: Optimal
		System.out.println(maxSubArray(arr));
	}

	private static int maxSubArrayBrute(int[] nums) {

		int maxSubarraySum = Integer.MIN_VALUE;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int currentSubarraySum = 0;
			for (int j = i; j < n; j++) {
				currentSubarraySum += nums[j];
				maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
			}
		}
		return maxSubarraySum;
		//TC:O(n square)
		//SC:O(1)
	}

	private static int maxSubArray(int[] arr) {

		int sum = 0, currentMaxSum = Integer.MIN_VALUE, n=arr.length;

		for (int i = 0; i < n; i++) {

			sum += arr[i];
			if (sum >= currentMaxSum) {
				currentMaxSum = sum;
			}
			if (sum < 0)
				sum = 0;
		}
		return currentMaxSum;

		//TC:O(n)
		//SC:O(1)
	}
}