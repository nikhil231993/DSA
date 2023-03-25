package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LC78SubsetList {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1 };
		List<Integer> list = new ArrayList<>();
		
		subsets(arr);

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> t = new ArrayList<List<Integer>>();
		List<Integer> single = new ArrayList();
		List<List<Integer>> t1 = test(nums, 0, single, t);
		System.out.println(t1);
		return t1;
	}

	public static List test(int[] nums, int i, List<Integer> single, List<List<Integer>> t) {
		if (i == nums.length) {
			t.add(new ArrayList<>(single));
			System.out.println(t);
			return t;
		}

		single.add(nums[i]);
		test(nums, i + 1, single, t);
		single.remove(single.size() - 1);
		test(nums, i + 1, single, t);
		return t;
	}

}
