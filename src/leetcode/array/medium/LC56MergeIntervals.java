package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergeIntervals {

	public static void main(String[] args) {
		

		int[][] twoDim = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		
		int[][] r = mergeIntervals(twoDim);
		for (int[] n : r)
			System.out.println(n[0] + " " + n[1]);
		
	}

	private static int[][] mergeIntervals(int[][] twoDim) {
		List<int[]> res = new ArrayList<>();
		Arrays.sort(twoDim, (a, b) -> a[0] - b[0]);// nlog(n)

		int start=twoDim[0][0];
		int end = twoDim[0][1];
		for (int[] row : twoDim) {
			if(end>=row[0]) {
				end=Math.max(end, row[1]);
			}else {
				res.add(new int[] { start, end });
				start = row[0];
				end = row[1];
			}
		}
		res.add(new int[] { start, end });
		return res.toArray(new int[0][]);

		// SC:O(1)
		// TC:O(n)

	}

}
