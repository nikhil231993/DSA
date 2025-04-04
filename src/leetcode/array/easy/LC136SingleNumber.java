package leetcode.array.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC136SingleNumber {

	public static void main(String[] args) {

		int[] arr = new int[] { 4, 1, 2, 1, 2 };

		// Approach 1: Using Map
		System.out.println(singleNumberUsingMap(arr));

		// Approach 2: Constant space
		System.out.println(singleNumber(arr));
	}

	private static Integer singleNumberUsingMap(int[] arr) {

		HashMap<Integer, Integer> map = new LinkedHashMap();
		for (Integer num : arr) {
			if (map.containsKey(num))
				map.put(num, map.get(num) + 1);
			else
				map.put(num, 1);
		}
		
		for(Map.Entry<Integer, Integer> m: map.entrySet())
			if (m.getValue() == 1)
				return m.getKey();

		return -1;

		//TC:O(N)
		//SC:O(N)
	}

	private static int singleNumber(int[] arr) {

		int result=0;
		for (int i = 0; i < arr.length; i++) {
			result ^= arr[i];
		}
		return result;

		//TC:O(N)
		//SC:O(1)
	}
}
