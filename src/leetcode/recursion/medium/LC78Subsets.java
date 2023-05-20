package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC78Subsets {

	public static void main(String[] args) {
		int[] nums = new int[] { 5, 2, 1 };
		List<List<Integer>> list = new ArrayList<>();
		subset(list, nums, new ArrayList<>(), 0);
		System.out.println(list);

		System.out.println("###########################");
		List<Integer> sumList = new ArrayList();
		subsetSum(nums, sumList, 0, 0);
		Collections.sort(sumList);
		System.out.println(sumList);


	}

	private static void subsetSum(int[] nums, List<Integer> arrayList, int i, int sum) {
		if (i >= nums.length) {
			arrayList.add(sum);
			return;
		}
		sum += nums[i];
		subsetSum(nums, arrayList, i + 1, sum);
		sum -= nums[i];
		subsetSum(nums, arrayList, i + 1, sum);
		// TC:2 raise to N *k taking k as avg length to put values inot List of list+2
		// raise to N log N for sorting the response
		// SC: 2 raise to n as there are 2 raise to n subsets + o(n) auxiliary space

	}

	// Below is leetcode solution
	private static void subset(List<List<Integer>> list, int[] nums, ArrayList arrayList, int i) {
		
		if(i==nums.length) {
			list.add(new ArrayList<>(arrayList));
			return;
		}
		arrayList.add(nums[i]);
		subset(list, nums, arrayList, i+1);
		arrayList.remove(arrayList.size() - 1);
		subset(list, nums, arrayList, i + 1);

		// TC:2 raise to N *k taking k as avg length to put values into List of list
		// SC: 2 raise to n as there are 2 raise to n subsets + o(n) auxiliary space

	}

}
