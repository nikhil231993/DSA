package leetcode.medium.recursion;

import java.util.ArrayList;
import java.util.List;

public class LC46Permutations {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> list = new ArrayList();
		List<Integer> arr=new ArrayList();
		boolean[] flag = new boolean[nums.length];
		permutations(nums, list, arr, flag);
		System.out.println(list);

	}

	private static void permutations(int[] nums, List<List<Integer>> list, List<Integer> arr, boolean[] flag) {
		
		if(nums.length==arr.size()) {
			list.add(new ArrayList<Integer>(arr));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!flag[i]) {
				flag[i] = true;
				arr.add(nums[i]);
				permutations(nums, list, arr, flag);
				flag[i] = false;
				arr.remove(arr.size() - 1);
			}
			// TC:n(loop)*n!(permutatio combinations)
			// SC:O(n)(flag array)+O(n)ausxiliary space i.e depth+size of list
		}

	}

}
