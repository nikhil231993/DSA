package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V11PrintAllSubsequenceContainingNoDuplicates {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2 };
		Arrays.sort(arr);
		List<Integer> list = new ArrayList<>();
		List<List<Integer>> parent = new ArrayList<List<Integer>>();
		List<List<Integer>> parent1 = new ArrayList<List<Integer>>();
		printSubsequence(arr, list, 0, parent);
		printSubsequenceWithoutDuplicates(arr, parent1, list, 0);
		System.out.println(parent1);

	}

	private static void printSubsequence(int[] arr, List<Integer> list, int i, List<List<Integer>> parent) {
		if (i >= arr.length) {
			if (!parent.contains(list)) {
				parent.add(new ArrayList<>(list));
			}
			return;
		}

		list.add(arr[i]);
		printSubsequence(arr, list, i + 1, parent);
		list.remove(list.size() - 1);
		printSubsequence(arr, list, i + 1, parent);

		// TC:O(2 raised to N + k)
		// SC:O(2N) as at the max we will have 3 functions in stack
	}

	private static void printSubsequenceWithoutDuplicates(int[] arr, List<List<Integer>> list, List<Integer> arr1,
			int index) {

		list.add(new ArrayList<>(arr1));

		for (int i = index; i < arr.length; i++) {
			if (i > index && arr[i] == arr[i - 1]) {
				continue;
			}

			arr1.add(arr[i]);
			printSubsequenceWithoutDuplicates(arr, list, arr1, i + 1);
			arr1.remove(arr1.size() - 1);
		}
		// TC:2 raise to N * t (avg length of combinations)
		// SC:2 raise to n * k + O(n) (Auxiliary space)

	}


}
