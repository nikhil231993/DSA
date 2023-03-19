package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class V10PrintAllSubsequenceSumIncreasingOrder {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2 };
		List<Integer> list = new ArrayList<>();
		printSubsequence(arr, list, 0, 0);
		Collections.sort(list);
		System.out.println(list);

	}
	
	private static void printSubsequence(int[] arr, List<Integer> list, int i, int sum) {
		if (i >= arr.length) {
			list.add(sum);
			return;
		}

//		list.add(arr[i]);
		sum += arr[i];
		printSubsequence(arr, list, i + 1, sum);
//		list.remove(list.size() - 1);
		sum -= arr[i];
		printSubsequence(arr, list, i + 1, sum);
		// TC:O(2 raised to N + 2raised to N log (2 raise to N))
		// SC:O(2N) as there are 8 diff combinations so with duplicates it willbe 2
		// raise to N
	}


}
