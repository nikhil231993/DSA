package leetcode.recursion.medium;

import java.util.Arrays;
import java.util.List;

public class LC1239MaximumLengthConcatenatedStringWithUniqueCharacters {

	public static void main(String[] args) {
		List<String> arr = Arrays.asList("ab", "ac", "cd");
		int[] selected = new int[26];
		int len = 0;
		int i = 0;
		System.out.println(concat(arr, selected, i, len));

	}

	public static int concat(List<String> arr, int[] selected, int index, int len) {

		if (index == arr.size())
			return len;

		String currString = arr.get(index);

		if (compare(selected, currString) == false) {
			return concat(arr, selected, index + 1, len);
		} else {
			for (int i = 0; i < currString.length(); i++) {
				selected[currString.charAt(i) - 'a'] = 1;
			}
			len += currString.length();
			int op1 = concat(arr, selected, index + 1, len);
			for (int i = 0; i < currString.length(); i++) {
				selected[currString.charAt(i) - 'a'] = 0;
			}
			len -= currString.length();
			int op2 = concat(arr, selected, index + 1, len);

			return Math.max(op1, op2);
		}
	}

	private static boolean compare(int[] selected, String currString) {
		int[] self = new int[26];

		for (int i = 0; i < currString.length(); i++) {
			if (self[currString.charAt(i) - 'a'] == 1)
				return false;
			self[currString.charAt(i) - 'a'] = 1;
		}

		for (int i = 0; i < currString.length(); i++) {
			if (selected[currString.charAt(i) - 'a'] == 1)
				return false;
		}
		return true;
	}

}
