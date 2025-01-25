package leetcode.math.medium;

import java.util.Arrays;

public class LC462MinimumEqual2 {

	public static void main(String[] args) {

		int[] num = new int[] { 1, 3, 7, 8, 11 };

		// Approach 1
		System.out.println(minMoves(num));

		// Approach 2 Best approach
		System.out.println(minMovesBetter(num));
	}

	public static int minMoves(int[] nums) {

		//Using median approach
		Arrays.sort(nums);

		int median=0;
		int n=nums.length;
		if(n % 2==1)
			median=nums[n/2];
		else
			median=(nums[n/2]+nums[n/2-1])/2;
		int minop=0;
		for(int no:nums){
			minop+=Math.abs(no-median);
		}
		return minop;

		//Time complexity : O(nlogn). Sorting will take O(nlogn) time.
		//Space complexity : O(1). Only single extra variable is used.
	}

	public static int minMovesBetter(int[] nums) {

		Arrays.sort(nums);
		int left = 0, right = nums.length - 1;
		int minMoves = 0;

		while (left < right) {
			minMoves += Math.abs(nums[left++] - nums[right--]); // absolute value is not needed as left > right
		}
		return minMoves;

		//Time complexity : O(nlogn). Sorting will take O(nlogn) time.
		//Space complexity : O(1). No extra space required.
	}
}
