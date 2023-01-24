package learningLogic.recursion;

import java.util.ArrayList;
import java.util.List;

public class V6PrintSubsequences {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 1 };
		List<Integer> list = new ArrayList<>();
		printSubsequence(arr, list, 0);

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
		// TC:O(2 raised to N)
		// SC:O(N) as at the max we will have 3 functions in stack
	}



}
