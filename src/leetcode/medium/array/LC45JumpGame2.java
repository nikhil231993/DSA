package leetcode.medium.array;

public class LC45JumpGame2 {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 0, 1, 4 };

		System.out.println(jumpGame2(nums));

	}

	private static int jumpGame2(int[] nums) {
		int farthest = 0;
		int curFarthest = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			farthest = Math.max(curFarthest, nums[i] + i);
			if (i == curFarthest) {
				count++;
				curFarthest = farthest;
			}
		}
		return count;

		// SC:O(1)
		// TC:O(n)
	}

}