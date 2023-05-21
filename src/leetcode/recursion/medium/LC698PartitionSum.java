package leetcode.recursion.medium;

public class LC698PartitionSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 2,1,4,5,6 };
		int k = 3;
		System.out.println(canPartitionKSubsets(nums, k));

	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];
		if (sum % k != 0)
			return false;

		int requiredBucketSum = sum / k;
		boolean[] flag = new boolean[nums.length];
		return subsets(requiredBucketSum, 0, 0, flag, nums, 1, k);

	}

	public static boolean subsets(int requiredBucketSum, int bucketSum, int i, boolean[] flag, int[] nums,
			int bucketCount, int k) {
		if (bucketCount == k)
			return true;

		if (bucketSum > requiredBucketSum)
			return false;

		if (i >= nums.length)
			return false;

		if (bucketSum == requiredBucketSum) {
			return subsets(requiredBucketSum, 0, 0, flag, nums, bucketCount + 1, k);
		}


		if (flag[i]) {
			return subsets(requiredBucketSum, bucketSum, i + 1, flag, nums, bucketCount, k);
		} else {
			flag[i] = true;
			bucketSum += nums[i];
			boolean op1 = subsets(requiredBucketSum, bucketSum, i + 1, flag, nums, bucketCount, k);

			flag[i] = false;
			bucketSum -= nums[i];
			boolean op2 = subsets(requiredBucketSum, bucketSum, i + 1, flag, nums, bucketCount, k);

			return op1 || op2;
		}

		// TC:O(2 raise to (N(height)*k(no of subarray)))
		// SC:O(N*K)

	}

}
