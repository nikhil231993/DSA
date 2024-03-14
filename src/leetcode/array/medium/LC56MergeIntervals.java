package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56MergeIntervals {

	public static void main(String[] args) {

		int[][] twoDim = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		//Approach 1: brute (Not needed)
		System.out.println(merge(twoDim));

		//Approach 2: optimal
		int[][] r = mergeIntervals(twoDim);
		for (int[] n : r)
			System.out.println(n[0] + " " + n[1]);
	}

	private static List<List<Integer>> merge(int[][] twoDim) {

		int n=twoDim.length;
		Arrays.sort(twoDim, (a, b) -> a[0] - b[0]);// nlog(n)

		List<List<Integer>> ans=new ArrayList<>();

		for(int i=0;i<n;i++){
			int start=twoDim[i][0];
			int end=twoDim[i][1];

			if(!ans.isEmpty() && end<=ans.get(ans.size()-1).get(1))
				continue;
			for(int j=i+1;j<n;j++){
				if(end>=twoDim[j][0]){
					end=Math.max(end,twoDim[j][1]);
				}else{
					break;
				}
			}
			ans.add(Arrays.asList(start,end));
		}
		return ans;

		//TC:O(nlogn) +O(2n) as we are not looping through each element for inner loop
		//SC:O(n) in case none of them are overlapping
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
		// TC:O(nlogn)+o(n)
	}
}
