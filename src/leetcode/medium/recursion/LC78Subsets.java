package leetcode.medium.recursion;

import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> list = new ArrayList<>();
		subset(list, nums, new ArrayList<>(), 0);
		System.out.println(list);


	}

	private static void subset(List<List<Integer>> list, int[] nums, ArrayList arrayList, int i) {
		
		if(i==nums.length) {
			list.add(new ArrayList<>(arrayList));
			return;
		}
		arrayList.add(nums[i]);
		subset(list, nums, arrayList, i+1);
		arrayList.remove(arrayList.size() - 1);
		subset(list, nums, arrayList, i + 1);

	}

}
