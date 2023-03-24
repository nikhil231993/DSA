package leetcode.medium.recursion;

import java.util.ArrayList;
import java.util.List;

public class LC39CombinationSum1 {

	public static void main(String[] args) {
		int[] num = new int[] { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> list = new ArrayList();
		combinationSum(list, new ArrayList<Integer>(), num, 0, target);
		System.out.println(list);

		List<List<Integer>> newList = new ArrayList();
		combinationSumSecondApproach(newList, new ArrayList<Integer>(), num, 0, target);
		System.out.println(newList);

	}

	private static void combinationSum(List<List<Integer>> list, ArrayList<Integer> arrayList, int[] num, int i,
			int target) {

		if (i == num.length) {
			if (target == 0) {
				list.add(new ArrayList<Integer>(arrayList));
			}
			return;
		}

		if (num[i] <= target) {

			arrayList.add(num[i]);
			combinationSum(list, arrayList, num, i, target - num[i]);
			arrayList.remove(arrayList.size() - 1);
		}
		combinationSum(list, arrayList, num, i + 1, target);

	}

	private static void combinationSumSecondApproach(List<List<Integer>> list, ArrayList<Integer> arrayList, int[] num,
			int index, int target) {

		if (target == 0) {
			list.add(new ArrayList<Integer>(arrayList));
			return;
		}

		for (int i = index; i < num.length; i++) {

			if (num[i] <= target) {

				arrayList.add(num[i]);
				combinationSum(list, arrayList, num, i, target - num[i]);
				arrayList.remove(arrayList.size() - 1);
			}
			// TC:O(2 raised to t) where t is no of times
			// SC:O(k(avg length)*x(combinations))
			// If instead of syso we use list of list then TC will be 2 raised to t *k where
			// k is length of combination as adding into list is linear TC and not constant
		}

	}

}
