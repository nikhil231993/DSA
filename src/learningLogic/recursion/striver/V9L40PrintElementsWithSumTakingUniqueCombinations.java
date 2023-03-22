package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V9L40PrintElementsWithSumTakingUniqueCombinations {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 2 };
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> arr1 = new ArrayList<>();
		Arrays.sort(arr);
		printSubsequenceSumOnce(arr, list, 4, arr1, 0);
		System.out.println(list);

	}

	private static void printSubsequenceSumOnce(int[] arr, List<List<Integer>> list, int target, List<Integer> arr1,
			int index) {
		if (target == 0) {
			list.add(new ArrayList<>(arr1));
			return;
		}
		for (int i = index; i < arr.length; i++) {
			if (i > index && arr[i] == arr[i - 1]) {
				continue;
			}
			if(arr[i]>target) {
				break;
			}
			
			arr1.add(arr[i]);
			printSubsequenceSumOnce(arr, list, target - arr[i], arr1, i + 1);
			arr1.remove(arr1.size()-1);
		}

		// TC:O(2 raise to N) * k when unique elements are there
		// SC:K*x(combinations)

	}


}
