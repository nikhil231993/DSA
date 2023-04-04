package leetcode.string.easy;

public class LC28FindFirstOccurrenceInAString {

	public static void main(String[] args) {
		String haystack = "test";
		String needle = "st";

		System.out.println(findOccurrence(haystack, needle));

	}

	private static int findOccurrence(String haystack, String needle) {
		int h = haystack.length();
		int n = needle.length();

		for (int i = 0; i < h - n + 1; i++) {
			int k = i;
			if (haystack.charAt(i) == needle.charAt(0)) {
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
	}

}
