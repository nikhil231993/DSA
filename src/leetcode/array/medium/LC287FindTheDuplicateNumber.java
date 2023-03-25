package leetcode.array.medium;

public class LC287FindTheDuplicateNumber {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 4, 2, 1 };

		// System.out.println(duplicateNumber(nums));
		System.out.println(duplicateNumberUsingSlowAndFast(nums));

	}

	private static int duplicateNumberUsingSlowAndFast(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		int ptr1 = nums[0];
		int ptr2 = slow;
		while (ptr1 != ptr2) {
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}
		return ptr1;

		// TC:O(n)
		// SC:O(1)

	}

	private static int duplicateNumber(int[] nums) {

		for (int n : nums) {
			n = Math.abs(n);
			if (nums[n] < 0)
				return n;
			else
				nums[n] *= -1;
		}
		return -1;

		// SC:O(1)
		// TC:O(n)

	}

}
