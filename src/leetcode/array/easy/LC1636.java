package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC1636 {

	public static void main(String[] args) {

		int[] num = new int[] { -1, 1, -6, 4, 5, -6, 1, 4, 1 };
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num.length; i++)
			list.add(num[i]);
		Comparator<Integer> com = new LC1636ComparList();
			Collections.sort(list, com);
//		int[] nums = sortByFrequencey(num);
		for (Integer n : list) {
			System.out.print(n);
		}

	}

//	public static int[] sortByFrequencey(int[] nums) {
//		Map<Integer, Integer> map = new HashMap<>();
//		for (int num : nums) {
//			map.put(num, map.getOrDefault(num, 0) + 1);
//		}
//
//		List<Integer> list = new ArrayList<>(map.keySet());
//		Collections.sort(list, (a, b) -> {
//			return (map.get(a) == map.get(b)) ? b - a : map.get(a) - map.get(b);
//		});
//
//		int[] res = new int[nums.length];
//		int i = 0;
//		for (int num : list) {
//			for (int j = 0; j < map.get(num); j++) {
//				res[i++] = num;
//			}
//		}
//		return res;
//
//	}

}
