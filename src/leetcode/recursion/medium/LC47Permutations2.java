package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC47Permutations2 {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 1, 2 };
		boolean[] flag = new boolean[nums.length];

		// Approach 1
		List<List<Integer>> list = new ArrayList<>();
		permutations(list, nums, new ArrayList<Integer>(), flag);
		System.out.println(list);
		
		// Approach 2
		Set<List<Integer>> newList = new HashSet<>();
		permutationsSecondApproach(newList, nums, 0);
		System.out.println(newList);

		// Approach 3
		List<List<Integer>> newSetList = new ArrayList<>();
		permutationsSecondApproachUsingSet(newSetList, nums, 0);
		System.out.println(newSetList);
	}

	private static void permutationsSecondApproachUsingSet(List<List<Integer>> newSetList, int[] nums, int index) {

		if (index == nums.length) {
			List<Integer> arr = new ArrayList<>();
			for (Integer n : nums)
				arr.add(n);
			newSetList.add(arr);
			return;
		}

		Set<Integer> set = new HashSet<>();
		for (int i = index; i < nums.length; i++) {
			if (set.add(nums[i])) {
			swap(i, index, nums);
			permutationsSecondApproachUsingSet(newSetList, nums, index + 1);
			swap(i, index, nums);
			}
		}
	}

	private static void permutationsSecondApproach(Set<List<Integer>> newList, int[] nums, 
			int index) {
		
		if(index==nums.length) {
			List<Integer> arr = new ArrayList<Integer>();
			for (Integer n : nums)
				arr.add(n);
			newList.add(arr);
			return;
		}

		for(int i=index;i<nums.length;i++) {
			swap(i, index, nums);
			permutationsSecondApproach(newList, nums, index + 1);
			swap(i, index, nums);
		}
	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void permutations(List<List<Integer>> list, int[] nums, ArrayList arrayList, boolean[] flag) {
		
		if (arrayList.size() == nums.length) {
			list.add(new ArrayList<Integer>(arrayList));
			return;
		}
		

		for(int i=0;i<nums.length;i++) {
			if(flag[i]) continue;
			if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])
				continue;
			
			flag[i]=true;
			arrayList.add(nums[i]);
			permutations(list, nums, arrayList, flag);
			flag[i]=false;
			arrayList.remove(arrayList.size() - 1);
		}
	}
}
