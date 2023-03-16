package learningLogic.recursion.striver;

import java.util.ArrayList;
import java.util.List;

public class V12Permutations {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> parentList = new ArrayList<>();
		permutations(nums, parentList, 0);
		System.out.println(parentList);

	}

	private static void permutations(int[] nums, List<List<Integer>> parentList, int index) {
		if (index == nums.length) {
			List<Integer> ds = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				ds.add(nums[i]);
			}
			parentList.add(new ArrayList<Integer>(ds));
			return;
		}
		
		for(int i=index;i<nums.length;i++) {
			swap(i,index,nums);
			permutations(nums, parentList, index + 1);
			swap(i, index, nums);
		}

	}

	private static void swap(int i, int j, int[] nums) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;

	}


}
