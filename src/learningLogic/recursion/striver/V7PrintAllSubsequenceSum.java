package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class V7PrintAllSubsequenceSum {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 2, 0 };
		List<Integer> list = new ArrayList<>();
		printSubsequence(arr, list, 0, 0, 3);

	}

	private static void printSubsequence(int[] arr, List<Integer> list, int i, int s,int sum) {
		if (i == arr.length) {
			if (s == sum) { 
				System.out.println(list);
				
			}
			return;
		}

		list.add(arr[i]);
		s+=arr[i];
		printSubsequence(arr, list, i + 1, s, sum);
		list.remove(list.size() - 1);
		s -= arr[i];
		printSubsequence(arr, list, i + 1, s, sum);
		// TC:O(2 raised to N)
		// SC:O(N) as at the max we will have 3 functions in stack
	}

}
