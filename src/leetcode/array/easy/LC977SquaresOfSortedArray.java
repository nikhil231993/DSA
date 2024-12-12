package leetcode.array.easy;

import java.util.Arrays;

public class LC977SquaresOfSortedArray {

	public static void main(String[] args) {

		int[] num=new int[] {-4,-1,0,3,10};

		//Approach 1:Brute Force
		int[] res=sortedSquaresBrute(num);
		for (Integer n : res)
			System.out.println(n);

		System.out.println("###############");

		//Approach 2:Optimal
		int[] num1=new int[] {-4,-1,0,3,10};
		int[] result = sortedSquares(num1);
		for (Integer n : result)
			System.out.println(n);
	}

	private static int[] sortedSquaresBrute(int[] nums) {

		 for(int i=0;i<nums.length;i++){
		 	nums[i]*=nums[i];
		 }
		 Arrays.sort(nums);
		 return nums;

		// TC:O(n log n)
		// SC:O(1)
	}

	public static int[] sortedSquares(int[] nums) {

		int[] result = new int[nums.length];
		int l = 0, r = nums.length - 1, k = result.length - 1;

		while (l <= r) {
			if (nums[l] * nums[l] >= nums[r] * nums[r]) {
				result[k--] = nums[l] * nums[l];
				l++;
			} else {
				result[k--] = nums[r] * nums[r];
				r--;
			}
		}
		return result;

		// TC:O(n)
		// SC:O(n)
	}
}
