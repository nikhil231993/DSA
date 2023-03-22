package leetcode.medium.recursion;

import java.util.ArrayList;
import java.util.List;

public class LC46Permutations {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> list = new ArrayList();
		List<Integer> arr=new ArrayList();
		boolean[] flag = new boolean[nums.length];
		permutations(nums, list, arr, flag);
		System.out.println(list);

		List<List<Integer>> newList = new ArrayList();
		permutationsSecondApproach(nums, newList, 0);
		System.out.println(newList);

	}

	private static void permutationsSecondApproach(int[] nums, List<List<Integer>> list, int index) {
		if (index == nums.length) {
			List<Integer> ds = new ArrayList();
			for (int n : nums)
				ds.add(n);
			list.add(new ArrayList<>(ds));
			return;
		}

		for (int i = index; i < nums.length; i++) {
			swap(i, index, nums);
			permutationsSecondApproach(nums, list, index + 1);
			swap(i, index, nums);
		}
		// TC:n!*n
		// SC:O(n) auxiliary space + n! to save result

	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;

	}

	private static void permutations(int[] nums, List<List<Integer>> list, List<Integer> arr, boolean[] flag) {

		if (nums.length == arr.size()) {
			list.add(new ArrayList<Integer>(arr));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!flag[i]) {
				flag[i] = true;
				arr.add(nums[i]);
				permutations(nums, list, arr, flag);
				flag[i] = false;
				arr.remove(arr.size() - 1);
			}
//			// TC:n(loop)*n!(permutatino combinations)
//			// SC:O(n)(flag array)+O(n)auxiliary space i.e depth+size of list
		}

	}

}
