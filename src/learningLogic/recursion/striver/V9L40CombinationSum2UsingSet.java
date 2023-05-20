package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class V9L40CombinationSum2UsingSet {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2 };
		Set<List<Integer>> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		System.out.println("------------");
		printSubsequenceSumOnce(arr, set, list, 0, 4, 0);
		for (List s : set)
			System.out.println(s);

	}


	private static void printSubsequenceSumOnce(int[] arr, Set<List<Integer>> set, List<Integer> list, int i,
			int target, int sum) {
		if (i == arr.length) {
			if (sum == target) {
				set.add(new ArrayList<>(list));

			}
			return;
		}

		if (sum <= target) {
			list.add(arr[i]);
			sum += arr[i];
			printSubsequenceSumOnce(arr, set, list, i + 1, target, sum);
			list.remove(list.size() - 1);
			sum -= arr[i];
		}
		printSubsequenceSumOnce(arr, set, list, i + 1, target, sum);
		// TC:O(2 raised to t) where t is no of times
		// SC:O(k(avg length)*x(combinations)) as at the max we will have 3 functions in
		// stack
		// If instead of syso we use set of list then TC will be 2 raised to t *k *log
		// n as we are also putting values into a set where
		// k is length of combination as adding into list is linear TC and not constant
	}

}
