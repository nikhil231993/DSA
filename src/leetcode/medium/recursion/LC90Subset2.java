package leetcode.medium.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90Subset2 {

	public static void main(String[] args) {
		int[] nums = new int[] { 0 };
		List<List<Integer>> list = new ArrayList<>();
		subsetSets(nums, list, new ArrayList(), 0);
		Arrays.sort(nums);
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
		}

	}

}
