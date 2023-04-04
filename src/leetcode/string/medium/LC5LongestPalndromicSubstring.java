package leetcode.string.medium;

public class LC5LongestPalndromicSubstring {

	public static void main(String[] args) {
		String s = "a";

		System.out.println(longestPalindrome(s));

	}

	public static String longestPalindrome(String s) {
		String palin = "";
		for (int i = 0; i < s.length(); i++) {
			int j = i;
			while (j < s.length()) {
				if (isPalindrome(s, i, j)) {
					if (palin.length() < s.substring(i, j + 1).length())
						palin = s.substring(i, j + 1);
				}
				j++;
			}

		}
		return palin;

	}

	public static boolean isPalindrome(String s, int start, int end) {
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

}
