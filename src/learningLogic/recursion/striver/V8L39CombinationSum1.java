package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class V8L39CombinationSum1 {

	public static void main(String[] args) {
		int[] arr = { 2,3,6,7 };
		List<Integer> list = new ArrayList<>();
		printSubsequenceSumOnce(arr, list, 0, 7);
		System.out.println("##############");
		printSubsequenceSumOnce(arr, list, 0, 4, 0);

	}

	private static void printSubsequenceSumOnce(int[] arr, List<Integer> list, int i, int target) {
		if (i == arr.length) {
			if (target == 0) {
				System.out.println(list);
			}
			return;
		}

		if (arr[i] <= target) {
			list.add(arr[i]);
			printSubsequenceSumOnce(arr, list, i, target - arr[i]);
			list.remove(list.size() - 1);
		}
		printSubsequenceSumOnce(arr, list, i + 1, target);
		// TC:O(2 raised to t) where t is no of times
		// SC:O(k(avg length)*x(combinations))
		// If instead of syso we use list of list then TC will be 2 raised to t *k where
		// k is length of combination as adding into list is linear TC and not constant
	}

	// Above is faster below is slower
	// Alternative approach

	private static void printSubsequenceSumOnce(int[] arr, List<Integer> list, int i, int target, int sum) {
		if (i == arr.length) {
			if (sum == target) {
				System.out.println(list);
			}
			return;
		}

		if (sum <= target) {
			list.add(arr[i]);
			sum += arr[i];
			printSubsequenceSumOnce(arr, list, i, target, sum);
			list.remove(list.size() - 1);
			sum -= arr[i];
		}
		printSubsequenceSumOnce(arr, list, i + 1, target, sum);
		// TC:O(2 raised to t) where t is no of times*k
		// SC:O(k(avg length)*x(combinations))
		// If instead of syso we use list of list then TC will be 2 raised to t *k where
		// k is length of combination as adding into list is linear TC and not constant
	}
}
