package leetcode.array.easy;

public class LC14LongestCommomPrefix {

	public static void main(String[] args) {

		String[] strs = new String[] { "dog", "racecar", "car" };

		//Approach 1:
		System.out.println(fetchLngestCommonSequence(strs));

		//Approach 2:
		System.out.println(fetchLongestCommon(strs));
	}

	private static String fetchLongestCommon(String[] strs) {

		String s = strs[0];
		for (int i = 0; i < strs.length; i++) {
			while (strs[i].indexOf(s) != 0) {
				s = s.substring(0, s.length() - 1);
			}
		}
		return s;
	}

	private static String fetchLngestCommonSequence(String[] strs) {

		int minLength = minLength(strs);
		String result = "";
		char c;

		for (int i = 0; i < minLength; i++) {
			c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (c != strs[j].charAt(i)) {
					return result;
				}
			}
			result += c;
		}
		return result;
	}

	private static int minLength(String[] strs) {

		int min = strs[0].length();

		for (int i = 1; i < strs.length; i++) {
			if (strs[i].length() < min) {
				min = strs[i].length();
			}
		}
		return min;
	}
}
