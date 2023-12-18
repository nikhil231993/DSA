package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class V6PrintSubsequences {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		List<Integer> list = new ArrayList<>();
		printSubsequence(arr, list, 0);

		System.out.println("#####################################");
		printSubsequenceUsingSecondMethod(arr, list, 0);

	}

	private static void printSubsequence(int[] arr, List<Integer> list, int i) {
		if (i >= arr.length) {
			System.out.println(list);
			return;
		}

		list.add(arr[i]);
		printSubsequence(arr, list, i + 1);
		list.remove(list.size() - 1);
		printSubsequence(arr, list, i + 1);
		// TC:O(2 raised to N) * N(This is for printing in case line 20 uses for loop to
		// print)
		// SC:O(N) as at the max we will have 3 functions in stack .Also N is the no of
		// numbers in array
	}

	private static void printSubsequenceUsingSecondMethod(int[] arr, List<Integer> list, int index) {

		System.out.println(list);

		for (int i = index; i < arr.length; i++) {
			list.add(arr[i]);
			printSubsequenceUsingSecondMethod(arr, list, i + 1);
			list.remove(list.size() - 1);
		}
		// TC:O(2 raised to N)* N(This is for printing in case line 20 uses for loop to
		// print)
		// SC:O(N) as at the max we will have 3 functions in stack .Also N is the no of
		// numbers in array
	}
}
