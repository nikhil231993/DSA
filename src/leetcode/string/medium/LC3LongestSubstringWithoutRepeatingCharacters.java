package leetcode.string.medium;

import java.util.HashMap;
import java.util.HashSet;

public class LC3LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		String str = "pwwkew";

		//Approach 1
		System.out.println(lengthOfLongestSubstringUsingHashSet(str));
		//Approach 2 better
		System.out.println(lengthOfLongestSubstringUsingMap(str));
	}

	private static int lengthOfLongestSubstringUsingMap(String s) {

		HashMap<Character, Integer> m = new HashMap();
		int left = 0;
		int right = 0;
		int len = 0;
		while (right < s.length()) {
			if (m.containsKey(s.charAt(right))) {
				left = Math.max(m.get(s.charAt(right)) + 1, left);
			}
			len = Math.max(len, right - left + 1);
			m.put(s.charAt(right), right);
			right++;
		}
		return len;
		//TC:O(N)
		//SC:O(N)
	}

	public static int lengthOfLongestSubstringUsingHashSet(String s) {

		HashSet<Character> h = new HashSet<>();
		int left = 0;
		int right = 0;
		int len = 0;
		while (right < s.length()) {

			if (!h.contains(s.charAt(right))) {
				h.add(s.charAt(right));
				len = Math.max(len, right - left + 1);
				right++;
			}
			else if (h.contains(s.charAt(right))) {
				h.remove(s.charAt(left));
				left++;
			}
		}
		return len;
		// TC:O(2N)
		// SC:O(N)
	}
}
