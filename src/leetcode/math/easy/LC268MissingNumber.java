package leetcode.math.easy;

import java.util.Arrays;

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

		//TC:O(n) ask me if u don't get it.This bit operation of XOR
		//SC:O(n)
	}

	public static int missingNumber(int[] nums) {

		int n = nums.length;
		int sum = 0;
		int actualSum = (n) * (n + 1) / 2;
		for (int i = 0; i < nums.length; i++)
			sum += nums[i];
		return actualSum - sum;

		// SC:O(1)
		// TC:O(n)
	}
}
