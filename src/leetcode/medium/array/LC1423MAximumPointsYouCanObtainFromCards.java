package leetcode.medium.array;

public class LC1423MAximumPointsYouCanObtainFromCards {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 1 };
		int k = 3;
		System.out.println(maxPoints(nums, k));

	}

	private static int maxPoints(int[] nums, int k) {
		int total = 0;

		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
			nums[i] = total;
		}
		int ans=0;
		int max=0;
		for (int i = 0; i <= k; i++) {
			int j = i + 3;
			if(i==0) {
				ans=nums[j];
			}else {
				ans=nums[j]-nums[i-1];
			}
			
			max=Math.max(total-ans, max);
		}
		return max;

		// SC:O(1)
		// TC:O(n)
	}

}
