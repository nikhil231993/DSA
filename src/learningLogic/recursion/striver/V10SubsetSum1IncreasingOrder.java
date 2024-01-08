package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class V10SubsetSum1IncreasingOrder {

	public static void main(String[] args) {

		// Brute force will be powset which will have a time complexity of O(2 raise to
		// n * n)

		int[] arr = { 3, 1, 2 };
		List<Integer> list = new ArrayList<>();
		printSubsequence(arr, list, 0, 0);
		Collections.sort(list);// Sorting as the answer is expected in sorted order
		System.out.println(list);
	}
	
	private static void printSubsequence(int[] arr, List<Integer> list, int i, int sum) {

		if (i >= arr.length) {
			list.add(sum);
			return;
		}

		sum += arr[i];
		printSubsequence(arr, list, i + 1, sum);
		sum -= arr[i];
		printSubsequence(arr, list, i + 1, sum);

		// TC:O(2 raised to N + 2raised to N log (2 raise to N))
		// SC:O( 2raise toN) as there are 8 diff combinations so with duplicates it will be 2
		// raise to N
	}

	private static void printSubsequenceDiffferentWay(int[] arr, List<Integer> list, int index, int sum) {

		list.add(sum);

		for (int i = index; i < arr.length; i++) {
			sum += arr[i];
			printSubsequence(arr, list, i + 1, sum);
			sum -= arr[i];
		}
		// TC:O(2 raised to N + 2raised to N log (2 raise to N))
		// SC:O( 2raise toN) as there are 8 diff combinations so with duplicates it will
		// be 2
		// raise to N
	}
}
