package leetcode.array.medium;

public class LC53MaxSubArrayKadane {

	public static void main(String[] args) {

		int[] arr = new int[] { 0, 1, 3, -5, 7 };

		//Approach 1: Brute
		System.out.println(maxSubArrayBrute(arr));

		//Approach 2: Optimal
		System.out.println(maxSubArray(arr));
	}

	public static int maxSubArrayBrute(int[] nums) {

		int maxSubarray = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int currentSubarray = 0;
			for (int j = i; j < nums.length; j++) {
				currentSubarray += nums[j];
				maxSubarray = Math.max(maxSubarray, currentSubarray);
			}
		}
		return maxSubarray;
	}

	private static int maxSubArray(int[] arr) {

		int sum = 0, currentMaxSum = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

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
