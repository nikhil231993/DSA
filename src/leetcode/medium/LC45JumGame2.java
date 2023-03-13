package leetcode.medium;

public class LC45JumGame2 {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 3, 1, 1, 4 };
		System.out.println(jumpGame2(nums));

	}

	private static int jumpGame2(int[] nums) {
		int jump=0;
		int currFarthest=0;
		int farthest=0;
		
		for(int i=0;i<nums.length-1;i++) {
			farthest=Math.max(farthest, i+nums[i]);
			if (i == currFarthest) {
				jump++;
				currFarthest = farthest;
			}
		}
		return jump;
	}

}
