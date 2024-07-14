package leetcode.string.easy;

public class LC28FindFirstOccurrenceInAString {

	public static void main(String[] args) {

		String haystack = "test";
		String needle = "st";

		//Approach 1
		System.out.println(strStrBrute(haystack,needle));

		//Approach 2
		System.out.println(findOccurrence(haystack, needle));
	}

	public static int strStrBrute(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	private static int findOccurrence(String haystack, String needle) {

		int h = haystack.length(), n = needle.length();

		for (int i = 0; i < h - n + 1; i++) {

			int k = i;
			if (haystack.charAt(k) == needle.charAt(0)) {
				int j = 0;
				while (j < n && haystack.charAt(k) == needle.charAt(j)) {
					j++;
					k++;
				}
				if (j == n)
					return i;
			}
		}
		return -1;

		//TC:O(m*n)
	}
}
