package leetcode.array.medium;

public class  LC45JumpGame2 {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 0 };
		System.out.println(jumpGame2(nums));
	}

	private static int jumpGame2(int[] nums) {

		int farthest = 0;
		int curFarthest = 0;
		int count = 0;

		for (int i = 0; i < nums.length-1; i++) {
			farthest = Math.max(farthest, nums[i] + i);
			if (i == curFarthest) {
				count++;
				curFarthest = farthest;
			}
		}
		return count;

		//TC:O(n)
		//SC:O(1)
	}
}
