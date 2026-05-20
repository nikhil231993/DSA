package leetcode.math.medium;

import java.util.Arrays;

public class LC462MinimumEqual2 {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 3, 7, 8, 11 };

		//Approach 1: Brute is in editorial and other 2 and 3 approach as well which might not be needed

		// Approach 4
        // https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/editorial/
		System.out.println(minMoves(num));

		// Approach 5 Best approach
		System.out.println(minMovesBetter(num));
	}

	private static int minMoves(int[] nums) {

		//Using median approach
		Arrays.sort(nums);

		int median=0, n=nums.length;
		if(n % 2==1)
			median=nums[n/2];
		else
			median=(nums[n/2]+nums[n/2-1])/2;
		int minop=0;
		for(int no:nums){
			minop+=Math.abs(no-median);
		}
		return minop;

		//Time complexity : O(n log n). Sorting will take O(n log n) time.
		//Space complexity : O(1). Only single extra variable is used.
	}

	private static int minMovesBetter(int[] nums) {
		//no steps to make left most equal to k is min+k
		//no of steps to make right most equal to k is max-k
		//so we can say that no of steps to make left most equal to right most is max-min
		//hence we can apply two pointer

		Arrays.sort(nums);
		int left = 0, right = nums.length - 1;
		int minMoves = 0;

		while (left < right) {
			minMoves += Math.abs(nums[left++] - nums[right--]); // absolute value is not needed as left > right
		}
		return minMoves;

		//Time complexity : O(n log n). Sorting will take O(n log n) time.
		//Space complexity : O(1). No extra space required.
	}
}
