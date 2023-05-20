package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class V14L13Permutations1UsingFlag {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> parentList = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean[] flag = new boolean[nums.length];
		permutations(nums, parentList, ds, flag);
		System.out.println(parentList);

	}

	private static void permutations(int[] nums, List<List<Integer>> parentList, List<Integer> ds, boolean[] flag) {
		if (ds.size() == nums.length) {
			parentList.add(new ArrayList<Integer>(ds));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!flag[i]) {
				flag[i] = true;
				ds.add(nums[i]);
				permutations(nums, parentList, ds, flag);
				flag[i] = false;
				ds.remove(ds.size() - 1);
			}
		}

		// TC:n!*n(looping)
		// sc:n(for ds)+n (flag array) without considering stack and auxiliary space O(n)

	}

}
