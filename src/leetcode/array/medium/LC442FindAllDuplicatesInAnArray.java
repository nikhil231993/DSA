package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LC442FindAllDuplicatesInAnArray {

	public static void main(String[] args) {

		int[] nums = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> r = findDuplicates(nums);

		System.out.println(r);
	}

	public static List<Integer> findDuplicates(int[] nums) {

		List<Integer> arr=new ArrayList();
		for(int i=0; i<nums.length; i++){
			int idx=Math.abs(nums[i]);
			if(nums[idx-1]<0)
	            arr.add(Math.abs(nums[i]));
			else
	            nums[idx-1]=-nums[idx-1];
		}
		return arr;

		//TC:O(n)
		//SC:O(1)
	}
}
