package leetcode.math.easy;

public class LC268MissingNumber {

	public static void main(String[] args) {
		int[] num = new int[] { 3, 0, 1 };
		
		//Approach 1
		System.out.println(missingNumber(num));
		//Approach 2
		System.out.println(missingNumberBettter(num));
	}

	private static int missingNumberBettter(int[] nums) {
		int n=nums.length;
		for(int i=0;i<nums.length;i++){
			n^=i;
			n^=nums[i];
		}
		return n;
	}

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = 0;
		int actualsum = (n) * (n + 1) / 2;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];
		return actualsum - sum;
		// SC:O(1)
		// TC:O(n)
	}
}
