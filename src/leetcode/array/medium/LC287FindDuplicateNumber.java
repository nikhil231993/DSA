package leetcode.array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;

public class LC287FindDuplicateNumber {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 3, 4, 2, 2 };

		//Other approaches are mentioned but they all need extra space

		//Approach 4: Optimal Below is the best approach
		System.out.println(duplicateNumberUsingSlowAndFast(nums));
	}

	private static int duplicateNumberUsingSlowAndFast(int[] nums) {

		int slow = nums[0];
		int fast = nums[0];

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		int ptr1 = nums[0];
		int ptr2 = slow;
		while (ptr1 != ptr2) {
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}
		return ptr1;

		//TC:O(n)
		//SC:O(1)
	}

	private static int duplicateNumber(int[] nums) {

		for (int n : nums) {
			n = Math.abs(n);
			if (nums[n] < 0)
				return n;
			else
				nums[n] *= -1;
		}
		return -1;

		//SC:O(1)
		//TC:O(n)
	}

	private static int duplicateNumberWithHashSet(int[] nums) {

		 HashSet<Integer> set=new LinkedHashSet();
		 for(int n:nums){
			 if(set.contains(n))
				 return n;
		     set.add(n);
		     }
		     return -1;

			//SC:O(n)
			//TC:O(n)
	}

	private static int duplicateNumberWithHashMap(int[] nums) {

	     HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();

		 for(int n:nums){
			hm.put(n, hm.getOrDefault(n,0)+1);
		 }
		 int num=0;
		 for( Map.Entry<Integer,Integer> entry: hm.entrySet()) {
			 if(entry.getValue()!=1) {
				  num= entry.getKey();
				 break;
			 }
		 }
		 return num;

		//SC:O(n)
		//TC:O(n)
	}
}
