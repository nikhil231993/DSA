package leetcode.array.medium;

import java.util.Arrays;

public class LC1465MaximumAreaOfCake {

	public static void main(String[] args) {
		int h = 5;
		int v = 4;
		int[] hc = new int[] { 1, 2, 4 };
		int[] vc = new int[] { 1, 3 };

		System.out.println(area(h, hc, v, vc));

		// h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]

	}

	private static int area(int h, int[] hc, int v, int[] vc) {
		long x = maxDiff(hc, h);
		long y = maxDiff(vc, v);

		return (int) ((long) (x * y) % (1000000007));
	}

	public static long maxDiff(int[] arr, int h) {

		Arrays.sort(arr);
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if ((arr[i] - arr[i - 1]) > max)
				max = arr[i] - arr[i - 1];
		}
		if ((h - arr[arr.length - 1]) > max)
			max = h - arr[arr.length - 1];
		return max;
	}

	// TC:O(nlogn)
	// SC:O(1)

}
