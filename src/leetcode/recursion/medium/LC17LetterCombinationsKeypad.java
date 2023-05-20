package leetcode.recursion.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17LetterCombinationsKeypad {

	public static void main(String[] args) {

		String digits = "23";
		System.out.println(letterCombinations(digits));

	}

	public static List<String> letterCombinations(String digits) {

		Map<Character, String> m = new HashMap();
		m.put('2', "abc");
		m.put('3', "def");
		m.put('4', "ghi");
		m.put('5', "jkl");
		m.put('6', "mno");
		m.put('7', "pqrs");
		m.put('8', "tuv");
		m.put('9', "wxyz");

		if (digits.length() == 0) {
			return new ArrayList();
		}
		List<String> list = new ArrayList();
		String temp = "";
		combination(m, list, digits, 0, temp);

		// TC: 3 raise to N
		// SC:O(N) where N is the digits length
		return list;
	}

	public static void combination(Map<Character, String> m, List<String> list, String digits, int index, String temp) {

		if (index == digits.length()) {
			list.add(temp);
			return;
		}
		String s = m.get(digits.charAt(index));

		for (int i = 0; i < s.length(); i++) {
			combination(m, list, digits, index + 1, temp + s.charAt(i));
		}
	}

}
