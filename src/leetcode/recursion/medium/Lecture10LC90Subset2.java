package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lecture10LC90Subset2 {

	public static void main(String[] args) {


		//Approach 1: Use the LC 78 logic and put the result in set and then finally convert to list
		//This will need both set and list which will add extra TC and SC

		//Approach 2:
		int[] nums = new int[] { 1,2,2 };
		Arrays.sort(nums); //Sorting to have duplicate values side by side
		List<List<Integer>> list = new ArrayList<>();
		subsetSets(nums, list, new ArrayList(), 0);
		System.out.println(list);
	}

	private static void subsetSets(int[] nums, List<List<Integer>> list, ArrayList arrayList, int index) {

		list.add(new ArrayList<>(arrayList));

		for (int i = index; i < nums.length; i++) {

			if (i > index && nums[i] == nums[i - 1])
				continue;
			arrayList.add(nums[i]);
			subsetSets(nums, list, arrayList, i + 1);
			arrayList.remove(arrayList.size() - 1);

			// TC:2 raise to N * t (avg length of combinations)
			// SC:2 raise to n * k + O(n) (Auxiliary space)
		}
	}
}
