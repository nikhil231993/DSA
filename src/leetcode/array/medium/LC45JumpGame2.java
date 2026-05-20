package leetcode.array.medium;

public class  LC45JumpGame2 {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 0 };
		System.out.println(jumpGame2(nums));
	}

	private static int jumpGame2(int[] nums) {

		int maxfarthest = 0, currentFarthest = 0, count = 0;

		for (int i = 0; i < nums.length-1; i++) {
			maxfarthest = Math.max( maxfarthest, nums[i] + i);
			if (i == currentFarthest) {
				count++;
				currentFarthest = maxfarthest;
			}
		}
		return count;

		//TC:O(n)
		//SC:O(1)
	}

	private static int jump(int[] nums) {
		if(nums.length==1)
			return 0;
		int maxFarthest=nums[0], currFarthest=Integer.MIN_VALUE;
		int n=nums.length, count=1;
		for(int i=0;i<n-1;i++){
			currFarthest=Math.max(currFarthest, nums[i]+i);
			if(i==maxFarthest){
				maxFarthest=currFarthest;
				count++;
			}
		}
		return count;
	}
}
