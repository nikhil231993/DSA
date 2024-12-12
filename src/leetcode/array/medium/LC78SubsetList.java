package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LC78SubsetList {

	public static void main(String[] args) {

		int[] arr = { 3, 2, 1 };
		subsets(arr);
	}

	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> t1 = new ArrayList<>();
	    test(nums, 0, new ArrayList(), t1);
		System.out.println(t1);
		return t1;
	}

	public static void test(int[] nums, int i, List<Integer> single, List<List<Integer>> t) {

		if (i == nums.length) {
			t.add(new ArrayList<>(single));
			return;
		}

		single.add(nums[i]);
		test(nums, i + 1, single, t);
		single.remove(single.size() - 1);
		test(nums, i + 1, single, t);

		//TC:O(2 raise to n)
		//SC:O(2 raise to n)
	}
}
