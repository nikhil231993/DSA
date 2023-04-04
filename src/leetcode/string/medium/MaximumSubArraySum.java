package leetcode.string.medium;

public class MaximumSubArraySum {

	public static void main(String[] args) {
		int[] num = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(maxSubArray(num));
		// optimizing
		System.out.println(maxSubArrayOptimizing(num));
		// kadnes algorithm states atht if sum is less than 0 reset sum to 0 else
		// continue;
		System.out.println(maxSubArrayKdanes(num));

		int[] r = maxSubArrayKdanesIndex(num);
		for (int i : r)
			System.out.println(i);


	}

	private static int[] maxSubArrayKdanesIndex(int[] num) {
		int sum = 0;
		int max = num[0];
		int start=0;
		int end=0;

		for (int i = 0; i < num.length; i++) {
			sum += num[i];
			if(sum>max) {
				max=sum;
				end=i;
			}
			if (sum < 0) {
				sum = 0;
				start=i+1;
			}

			// SC:O(n)
			}
		return new int[] { start, end };

	}

	private static int maxSubArrayKdanes(int[] num) {
		int sum = 0;
		int max = num[0];

		for (int i = 0; i < num.length; i++) {
			sum += num[i];
			max = Math.max(sum, max);
			if (sum < 0)
				sum = 0;

			// SC:O(n)
			}
		return max;

	}

	private static int maxSubArrayOptimizing(int[] num) {

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++) {
			int sum = 0;
			for (int j = i; j < num.length; j++) {
				sum += num[j];
				max = Math.max(sum, max);
			}
		}
		return max;

		// SC:O(1)
		// TC:O(n square)

	}

	private static int maxSubArray(int[] num) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < num.length; i++) {
			for (int j = i; j < num.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += num[k];
					max = Math.max(sum, max);
				}
			}
		}
		return max;

		// SC:O(1)
		// TC:O(n cube)
	}

}
