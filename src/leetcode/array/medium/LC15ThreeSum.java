package leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC15ThreeSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] n = new int[] { -1, 0, 1, 2, -1, -4 };
		
		List<List<Integer>> r = threeSum(n);
		List<List<Integer>> re = threeSumNCubeSpaceComplexity(n);
		System.out.println(re);
		scan.close();
	}

	private static List<List<Integer>> threeSumNCubeSpaceComplexity(int[] n) {
		Arrays.sort(n);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < n.length; i++) {
			if (i != 0 && (n[i] == n[i - 1]))
				continue;
			for (int j = i + 1; j < n.length; j++) {
				if (j != i + 1 && (n[j] == n[j - 1]))
					continue;
				for (int k = j + 1; k < n.length; k++) {
					List<Integer> r = new ArrayList<Integer>();
					if (k != j + 1 && (n[k] == n[k - 1]))
						continue;

					if (n[i] + n[j] + n[k] == 0) {
						r.add(n[i]);
						r.add(n[j]);
						r.add(n[k]);
						result.add(r);
					}
				}

		}
		}
		return result;
	}

	private static List<List<Integer>> threeSum(int[] n) {
		Arrays.sort(n);
		List<List<Integer>> t=new ArrayList<List<Integer>>();
		for (int i = 0; i < n.length - 2; i++) {
			if (i == 0 || (i > 0 && n[i] != n[i - 1])) {
				int l = i + 1;
				int h = n.length - 1;
				int sum = 0 - n[i];
				while (l < h) {
					if (n[l] + n[h] == sum) {
						t.add(Arrays.asList(n[i], n[l], n[h]));
						while (l < h && n[l] == n[l + 1])
							l++;
						while (l < h && n[h] == n[h - 1])
							h--;

						l++;
						h--;
					}
					else if (n[l] + n[h] < sum)
						l++;
					else
						h--;
				}
			}
		}
		return t;
	}

}
