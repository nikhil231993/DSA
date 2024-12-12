package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture7LC78Subsets {

	public static void main(String[] args) {

		int[] nums = new int[] { 5, 2, 1 };
		List<List<Integer>> list = new ArrayList<>();
		subset(list, nums, new ArrayList<>(), 0);

		int[] nums1 = new int[] { 1,2 };
		List<List<Integer>> list1 = new ArrayList<>();
		subsetForLoop(list1, nums1, new ArrayList<>(), 0);
		System.out.println("for loop solution: \n" + list1);

		//Below is without any of the sorting
		//[[5, 2, 1], [5, 2], [5, 1], [5], [2, 1], [2], [1], []]

		//Below is to sort using size of list first followed by numbers
		//Result [[], [1], [2], [5], [2, 1], [5, 1], [5, 2], [5, 2, 1]]

//		Collections.sort(list,(a,b)->{
//			int min=Math.min(a.size(),b.size());
//			if(a.size()!=b.size())
//				return a.size()-b.size();
//			else {
//				for(int i=0;i<min;i++){
//					if(a.get(i)!=b.get(i))
//						return a.get(i)-b.get(i);
//				}
//			}
//			return 0;
//		});

		//Below is to sort by size of list
		Collections.sort(list,(a,b)->a.size()-b.size());
		//Result is [[], [5], [2], [1], [5, 2], [5, 1], [2, 1], [5, 2, 1]]
		System.out.println(list);

		//Approach 1: Brute Force is using Pow Set which has TC: 2 raise to N * N so we have to improve for extra N

		//Approach 2
		System.out.println("###########################");
		List<Integer> sumList = new ArrayList();
		subsetSum(nums, sumList, 0, 0);
		Collections.sort(sumList);
		System.out.println(sumList);

		//Approach 3 : Another way using for loop
		System.out.println("###########################");
		List<Integer> list2 = new ArrayList();
		subsetSumForLoop(nums, list2, 0, 0);
		Collections.sort(list2);
		System.out.println(list2);
	}

	private static void subsetForLoop(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {

		ans.add(new ArrayList(list));
		for(int i=index; i<nums.length; i++) {
			list.add(nums[i]);
			subsetForLoop(ans, nums, list, i + 1);
			list.remove(list.size() - 1);
		}
	}

	private static void subsetSumForLoop(int[] nums, List<Integer> list2, int index, int sum) {

		list2.add(sum);

		for(int i=index; i<nums.length;i++){
			sum+=nums[i];
			subsetSumForLoop(nums, list2, i+1, sum);
			sum-=nums[i];
		}
	}

	private static void subsetSum(int[] nums, List<Integer> arrayList, int i, int sum) {

		if (i >= nums.length) {
			arrayList.add(sum);
			return;
		}
		Collections.sort(arrayList);
		sum += nums[i];
		subsetSum(nums, arrayList, i + 1, sum);
		sum -= nums[i];
		subsetSum(nums, arrayList, i + 1, sum);

		// TC:2 raise to N * k taking k as avg length to put values into List of list + 2
		// raise to N log N for sorting the response
		// SC: 2 raise to n as there are 2 raise to n subsets + o(n) auxiliary space
	}

	// Below is leetcode solution
	private static void subset(List<List<Integer>> list, int[] nums, ArrayList arrayList, int i) {
		
		if(i==nums.length) {
			list.add(new ArrayList<>(arrayList));
			return;
		}
		arrayList.add(nums[i]);
		subset(list, nums, arrayList, i+1);
		arrayList.remove(arrayList.size() - 1);
		subset(list, nums, arrayList, i + 1);

		// TC:2 raise to N *k taking k as avg length to put values into List of list
		// SC: 2 raise to n as there are 2 raise to n subsets + o(n) auxiliary space
	}
}
