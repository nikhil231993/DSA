package leetcode.array.easy;

import java.util.HashMap;

public class LC1624SubstringBetweenEqualCharacters {

	public static void main(String[] args) {

		String s = "abca";
		System.out.println(lengthOfLargetSubstring(s));
	}

	private static int lengthOfLargetSubstring(String s) {

		HashMap<Character, Integer> msp = new HashMap<Character, Integer>();
		int maxDiff=0;

		for(int i=0; i<s.length(); i++) {
			if(msp.containsKey(s.charAt(i))) {
				int diff = i - msp.get(s.charAt(i));
				if(diff>maxDiff)
					maxDiff = diff;
			} else {
				msp.put(s.charAt(i), i);
			}
		}
		return maxDiff - 1;

		//TC:O(n)
		//SC:O(n)
	}
}
