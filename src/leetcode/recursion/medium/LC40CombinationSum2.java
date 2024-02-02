package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40CombinationSum2 {

	public static void main(String[] args) {

		int[] num = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		Arrays.sort(num);
		int target = 8;
		
		List<List<Integer>> list = new ArrayList<>();
		combinationSum2(list, new ArrayList(), target, 0, num);
		System.out.println(list);
	}

	private static void combinationSum2(List<List<Integer>> list, ArrayList arrayList, int target, int index,
			int[] num) {

			if(target==0) {
				list.add(new ArrayList<Integer>(arrayList));
			return;
			}

			for (int i = index; i < num.length; i++) {
				if (i > index && num[i] == num[i - 1])
					continue;
				if (target < num[i])
					break;

				arrayList.add(num[i]);
				combinationSum2(list, arrayList, target - num[i], i + 1, num);
				arrayList.remove(arrayList.size() - 1);

			// SC:k*x(no of combinations) ignoring auxiliary space
			// TC:if all elements all unique O(2 raise to n)*k(is the avg length of each
			// combinations)
		}
	}
}
