package learningLogic.recursion;

import java.util.HashSet;
import java.util.Set;

public class V9L40PrintElementsWithSum {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7 };
		Set<Integer> list = new HashSet<>();
		printSubsequenceSumOnce(arr, list, 0, 7);

	}

	private static void printSubsequenceSumOnce(int[] arr, Set<Integer> list, int i, int target) {
		if (i == arr.length) {
			if (target == 0) {
				System.out.println(list);
			}
			return;
		}

		if (arr[i] <= target) {
		list.add(arr[i]);
			printSubsequenceSumOnce(arr, list, i + 1, target - arr[i]);
		list.remove(list.size() - 1);
		}
		printSubsequenceSumOnce(arr, list, i + 1, target);
		// TC:O(2 raised to t) where t is no of times
		// SC:O(N) as at the max we will have 3 functions in stack
		// If instead of syso we use list of list then TC will be 2 raised to t *k where
		// k is length of combination as adding into list is linear TC and not constant
	}

}
