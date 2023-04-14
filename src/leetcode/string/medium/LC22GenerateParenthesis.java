package leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

public class LC22GenerateParenthesis {

	public static void main(String[] args) {
		int n = 3;

		List<String> result = new ArrayList();
		String s="";
		generate(n, 0, 0, s, result);
		System.out.println(result);
		// SC:O(2 raise to n) for recursion stack and o(n) to store values
		// TC:O(2 raise to n)
	}

	// Two conditions
	// 1.left parenthesis count should be less than n
	// 2.right parenthesis count should be less than left

	private static void generate(int n, int left, int right, String s, List<String> result) {
		if (s.length() == 2 * n) {
			result.add(s);
			return;
		}

		if (left < n) {
			generate(n, left + 1, right, s + "(", result);
		}
		if (right < left) {
			generate(n, left, right + 1, s + ")", result);
		}
		
	}

}
