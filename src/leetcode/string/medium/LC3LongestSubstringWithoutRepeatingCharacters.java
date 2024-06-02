package leetcode.string.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC3LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		String str = "pwwkew";

		//Approach 1: Brute Generate all the combinations which is TC O(N square)
		System.out.println(bruteApproach(str));

		//Approach 2: Better
		System.out.println(lengthOfLongestSubstringUsingHashSet(str));

		//Approach 2 better
		System.out.println(lengthOfLongestSubstringUsingMap(str));
	}

	public  static int bruteApproach(String str){

		if(str.length()==0)
			return 0;
		int maxans = Integer.MIN_VALUE;
		for (int i = 0; i < str.length(); i++){ // outer loop for traversing the string

			Set<Character > se = new HashSet <>();
			for (int j = i; j < str.length(); j++) // nested loop for getting different string starting with str[i]
			{
				if (se.contains(str.charAt(j))) // if element if found so mark it as ans and break from the loop
				{
					maxans = Math.max(maxans, j - i);
					break;
				}
				se.add(str.charAt(j));
			}
		}
		return maxans;

		//TC:O(n square)
		//SC:O(256)
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
		//SC:O(256)
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
			} else if (h.contains(s.charAt(right))) {
				h.remove(s.charAt(left));
				left++;
			}
		}
		return len;

		// TC:O(2N)
		//SC:O(256)
	}
}
