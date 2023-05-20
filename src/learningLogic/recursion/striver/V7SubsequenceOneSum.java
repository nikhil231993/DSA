package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class V7SubsequenceOneSum {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 2 };
		List<Integer> list = new ArrayList<>();
		printSubsequenceSumOnce(arr, list, 0, 0, 3);
		System.out.println("###################################");
		List<Integer> newList = new ArrayList<>();
		printSubsequenceSumOnceSecondMethod(arr, newList, 0, 0, 3);

	}

	private static boolean printSubsequenceSumOnce(int[] arr, List<Integer> list, int i, int s, int sum) {
		if (i == arr.length) {
			if (s == sum) {
				System.out.println(list);
				return true;
			}
			return false;
		}

		list.add(arr[i]);
		s+=arr[i];
		if (printSubsequenceSumOnce(arr, list, i + 1, s, sum))
			return true;
		list.remove(list.size() - 1);
		s -= arr[i];
		if (printSubsequenceSumOnce(arr, list, i + 1, s, sum))
			return true;
		
		return false;
		// TC:O(2 raised to N)
		// SC:O(N) as at the max we will have 3 functions in stack
	}

	private static boolean printSubsequenceSumOnceSecondMethod(int[] arr, List<Integer> list, int index, int s,
			int sum) {

			if (s == sum) {
				System.out.println(list);
				return true;
			}

		for (int i = index; i < arr.length; i++) {
			list.add(arr[i]);
			s += arr[i];
			if (printSubsequenceSumOnce(arr, list, i + 1, s, sum))
				return true;
			list.remove(list.size() - 1);
			s -= arr[i];
		}
		return false;
		// TC:O(2 raised to N)
		// SC:O(N) as at the max we will have 3 functions in stack
	}

}
