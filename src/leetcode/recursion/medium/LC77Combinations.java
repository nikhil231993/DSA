package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class LC77Combinations {

	public static void main(String[] args) {

		int n = 4;
		int k = 2;

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> arr1 = new ArrayList<>();
		combinations(list, n, arr1, k, 1);
		System.out.println(list);

		List<List<Integer>> newList = new ArrayList<>();
		List<Integer> arr2 = new ArrayList<>();
		combinationsSecondApproach(newList, n, arr2, k, 1);
		System.out.println(newList);
	}

	private static void combinations(List<List<Integer>> list, int n, List<Integer> arr1, int k, int index) {

		if (k == 0) {
			list.add(new ArrayList<>(arr1));
			return;
		}

		for (int i = index; i <= n - k + 1; i++) {
			arr1.add(i);
			combinations(list, n, arr1, k - 1, i + 1);
			arr1.remove(arr1.size() - 1);
		}
		// SC:O(n) as at the max it will go to max n i.e., height of the tree
		// TC:O(2 raise to N)
	}

	private static void combinationsSecondApproach(List<List<Integer>> list, int n, List<Integer> arr1, int k,
			int index) {

		if (n - index + 1 < k) {
			return;
		}
		if (k < 0) {
			return;
		}

		if (k == 0) {
			list.add(new ArrayList<>(arr1));
			return;
		}
		arr1.add(index);
		combinationsSecondApproach(list, n, arr1, k - 1, index + 1);
		arr1.remove(arr1.size() - 1);
		combinationsSecondApproach(list, n, arr1, k, index + 1);

		// SC:O(n) as at the max it will go to max n i.e., height of the tree
		// TC:O(2 raise to N)
	}
}
