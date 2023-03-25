package leetcode.array.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LC217ContainsDuplciate {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 1 };
		System.out.println(containsDuplicate(arr));

	}

	public static boolean containsDuplicate(int[] nums) {
	        
	        HashMap<Integer,Integer> map=new LinkedHashMap<>();
	        
	        for(int i=0;i<nums.length;i++){

			if (map.containsKey(nums[i])) {
				return true;
			} else {
				map.put(nums[i], 1);
	            }
	        }
		return false;
	        
	    }

}
