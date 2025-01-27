package leetcode.string.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC14LongestCommonPrefix {

	public static void main(String[] args) {

		String[] s = new String[] { "flower", "flow", "flight" };

		//Approach 1
		System.out.println(longestCommonPrefix(s));

		//Approach 2
		System.out.println(longestCommonPrefixWithWhile(s));
	}

	private static String longestCommonPrefixWithWhile(String[] s) {

		String first=s[0];
		for (int i = 1; i < s.length; i++) {
			while (s[i].indexOf(first) != 0) {
				first = first.substring(0, first.length() - 1);
			}
		}
		return first;
	}

	private static String longestCommonPrefix(String[] s) {

		int minLength = findMin(s);
		String first=s[0];

		char current;
		String temp="";

		for(int i=0;i<minLength;i++) {

			current=first.charAt(i);
			for(int j=1;j<s.length;j++) {
				if (current == s[j].charAt(i)) {
					continue;
				} else {
					return temp;
				}
			}
			temp += current;
		}
		return temp;

		//TC:O(min length String) + O(total strings)
		//SC:O(ans)
	}

	private static int findMin(String[] s) {

		int min = Integer.MAX_VALUE;
		for(String str:s) {
			min = Math.min(str.length(), min);
		}
		return min;
	}
}
