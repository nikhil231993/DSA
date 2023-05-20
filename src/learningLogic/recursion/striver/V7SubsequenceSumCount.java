package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class V7SubsequenceSumCount {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 0, 2 };
		List<Integer> list = new ArrayList<>();
		System.out.println(printSubsequenceSumOnce(arr, list, 0, 0, 3));


	}

	private static int printSubsequenceSumOnce(int[] arr, List<Integer> list, int i, int s, int sum) {
		//condition not satisfied
		//strictly done if array contains positives only
		if(s>sum)
			return 0;

		if (i == arr.length) {
			if (s == sum) {
				return 1;
			}
			return 0;
		}

//		list.add(arr[i]);
		s+=arr[i];
		int l = printSubsequenceSumOnce(arr, list, i + 1, s, sum);
//		list.remove(list.size() - 1);
		s -= arr[i];
		int r = printSubsequenceSumOnce(arr, list, i + 1, s, sum);
		// TC:O(2 raised to N)
		// SC:O(N) as at the max we will have 3 functions in stack
		
		return l + r;
	}

}
