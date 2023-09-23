package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class LC26RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 1, 2 };

		//Approach 1 Brute
		int[] result=removeDuplicatesBrute(arr1);
		for(Integer n:result)
			System.out.println(n);

		System.out.println("############");

		//Approach 2 Optimal
		int[] arr = new int[] { 1, 1, 2 };
		System.out.println("Size of arr after duplicate removal is: ");
		removeDuplicates(arr);
		for (Integer n : arr)
			System.out.println(n);
	}

	private static int[] removeDuplicatesBrute(int[] arr1) {

		List<Integer> list=new ArrayList<>();
		list.add(arr1[0]);
		for(int i=0;i<arr1.length;i++){
			if(list.get(list.size()-1)!=arr1[i])
				list.add(arr1[i]);
		}
		return list.stream().mapToInt(i->i).toArray();
		//SC:O(n)
		//TC:O(1)
	}

	private static void removeDuplicates(int[] arr) {

		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[j] != arr[i]) {
				arr[++j] = arr[i];
			}
		}
		while (j < arr.length - 1) {
			arr[++j] = 0;
		}

		//SC:O(1) we are using existing array
		//TC:O(n)
	}

}
