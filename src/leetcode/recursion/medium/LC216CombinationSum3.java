package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class LC216CombinationSum3 {

	public static void main(String[] args) {
		int k = 3;
		int target = 7;

		List<List<Integer>> list = new ArrayList();
		combinationSum3(list, new ArrayList(), target, k, 1);
		System.out.println(list);

		List<List<Integer>> newList = new ArrayList();
		combinationSum3SecondApproach(newList, new ArrayList(), target, k, 1);
		System.out.println(newList);

	}

	private static void combinationSum3SecondApproach(List<List<Integer>> newList, ArrayList arrayList, int target,
			int k, int index) {

		if (k == 0) {
			if (target == 0) {
				newList.add(new ArrayList<>(arrayList));
			}
			return;
		}

		for(int i=index;i<=9;i++) {
			arrayList.add(i);
			combinationSum3SecondApproach(newList, arrayList, target - i, k - 1, i + 1);
			arrayList.remove(arrayList.size() - 1);
		}

	}

	private static void combinationSum3(List<List<Integer>> list, ArrayList arrayList, int target, int k, int index) {
		if (index > 10) {
			return;
		}
		
		if (k == 0) {
			if (target == 0) {
				list.add(new ArrayList<>(arrayList));
			}
			return;
		}
		arrayList.add(index);
		combinationSum3(list, arrayList, target-index, k - 1, index + 1);
		arrayList.remove(arrayList.size() - 1);
		combinationSum3(list, arrayList, target, k, index+1);

		// TC:O(2 raise to 9 *k(avg length od combinations))
		// SC:k*x(no of combinations)+O(n)
	}

}
