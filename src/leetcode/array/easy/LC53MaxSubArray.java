package leetcode.array.easy;

public class LC53MaxSubArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 3, -5, 7 };
		System.out.println(maxSubArray(arr));
//TC:O(n)
//SC:O(1)
	}

	private static int maxSubArray(int[] arr) {

		int sum = 0;
		int currentMaxSum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum >= currentMaxSum) {
				currentMaxSum = sum;
			}

			if (sum < 0)
				sum = 0;
		}
		return currentMaxSum;
	}

}
