package leetcode.math.easy;

public class LC628MaximumProductThreeNumbers {

	public static void main(String[] args) {
		int[] num = new int[] { 1, 2, 3, 4 };
		System.out.println(maximumProduct(num));

	}

	public static int maximumProduct(int[] nums) {

		// 1st Approach is to use min heap and maxheap buthere it will be nlogn TC as
		// insertion and deletion in a heap takes log n time

		// 2nd approach is specific to this case where we need to find only 3 no

		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = nums[i];
			} else if (nums[i] > max2) {
				max3 = max2;
				max2 = nums[i];
			} else if (nums[i] > max3) {
				max3 = nums[i];
			}

			if (nums[i] < min1) {
				min2 = min1;
				min1 = nums[i];

			} else if (nums[i] < min2) {
				min2 = nums[i];
			}
		}

		return Math.max(max1 * max2 * max3, max1 * min1 * min2);

		// SC:O(1)
		// TC:O(n)

	}

}
