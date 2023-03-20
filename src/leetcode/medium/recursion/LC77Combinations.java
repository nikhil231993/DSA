package leetcode.medium.recursion;

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
		// SC:O(n)
		// TC:O(2 raise to N)

	}

}
