package leetcode.math.medium;

import java.util.HashMap;

public class LC593ValidSquare {

	public static void main(String[] args) {

		int[] p1 = new int[] { 0, 0 };
		int[] p2 = new int[] { 1, 1 };
		int[] p3 = new int[] { 1, 0 };
		int[] p4 = new int[] { 0, 1 };

		//This cannot be done by set as for (0,0),(1,1),(0,0) and (1,1) it will fail
		System.out.println(validSquare(p1, p2, p3, p4));
	}

	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

		int[] arr = new int[] { calculate(p1, p2), calculate(p1, p3), calculate(p1, p4), calculate(p2, p3),
				calculate(p3, p4), calculate(p4, p2) };

		HashMap<Integer, Integer> map = new HashMap();
		int max = 0;// To check diagonal
		for (int val : arr) {
			max = Math.max(max, val);
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		if (map.get(max) == 2 && map.size() == 2)//This condition very important as diagonal should have only 2 values and max map size should be 2
			return true;
		else
			return false;

		// SC:O(6)
		// TC:O(6)
	}

	public static int calculate(int[] a, int[] b) {
		return ((a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]));
	}
}
