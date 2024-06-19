package leetcode.array.easy;

import java.util.Arrays;
import java.util.HashSet;

public class LC217ContainsDuplicate {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 1 };

		//Approach 1
		System.out.println(containsDuplicate(arr));

		//Approach 2
		System.out.println(containsDuplicateApproach2(arr));
	}

	public static boolean containsDuplicate(int[] nums) {
	        
		HashSet<Integer> set=new HashSet<>();

		for(int i=0;i<nums.length;i++){

		if (set.contains(nums[i])) {
			return true;
		} else {
			set.add(nums[i]);
			}
		}
		return false;

		//TC:O(n)
		//SC:O(n)
	}

	public static boolean containsDuplicateApproach2(int[] nums) {

		Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]==nums[i+1])
				return true;
		}
		return false;

		//TC:O(nlogn)
		//SC:O(1)
	}
}
