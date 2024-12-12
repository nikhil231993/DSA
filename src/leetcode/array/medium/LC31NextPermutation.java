package leetcode.array.medium;

public class LC31NextPermutation {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 5,4,3,2 };

		//Approach 1 : Optimal
		nextPermutation(nums);
		for (Integer n : nums)
			System.out.println(n);
	}

	private static void nextPermutation(int[] nums) {

		int idx1 = -1, idx2 = -1;

		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				idx1 = i;
				break;
			}
		}
		if (idx1 < 0) {
			reverse(0, nums.length - 1, nums);
		} else {
			for (int i = nums.length - 1; i >= 0; i--) {
				if (nums[idx1] < nums[i]) {
					idx2 = i;
					break;
				}
			}
			swap(idx1, idx2, nums);
			reverse(idx1 + 1, nums.length - 1, nums);
		}

		//TC:O(3N)
		//SC:O(N)
	}

	private static void swap(int idx1, int idx2, int[] nums) {

		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}

	private static void reverse(int start, int end, int[] nums) {

		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
