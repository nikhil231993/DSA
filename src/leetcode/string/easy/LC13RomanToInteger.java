package leetcode.string.easy;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC13RomanToInteger {

	public static void main(String[] args) {

		String s = "III";
		System.out.println(romanToIntegerUsingMap(s));
		System.out.println(romanToIntegerWithoutUsingMap(s));

		// SC:O(1)
//	Symbol       Value
//		I             1
//		V             5
//		X             10
//		L             50
//		C             100
//		D             500
//		M             1000


	}

	private static int romanToIntegerWithoutUsingMap(String s) {
		int sum = 0;
		int num = 0;
		int forward=0;
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'I':
				num = 1;
				break;
			case 'V':
				num = 5;
				break;
			case 'X':
				num = 10;
				break;
			case 'L':
				num = 50;
				break;
			case 'C':
				num = 100;
				break;
			case 'D':
				num = 500;
				break;
			case 'M':
				num = 1000;
				break;
			}
			
			if (num < forward) {
				sum -= num;
			} else {
				sum += num;
			}
			forward = num;
		}
		return sum;
	}

	private static int romanToIntegerUsingMap(String s) {
		Map<Character, Integer> keyValueMapping = new LinkedHashMap();
		keyValueMapping.put('I', 1);
		keyValueMapping.put('V', 5);
		keyValueMapping.put('X', 10);
		keyValueMapping.put('L', 50);
		keyValueMapping.put('C', 100);
		keyValueMapping.put('D', 500);
		keyValueMapping.put('M', 1000);
		
		int sum = keyValueMapping.get(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {

			if (keyValueMapping.get(s.charAt(i)) <= keyValueMapping.get(s.charAt(i + 1))) {
				sum += keyValueMapping.get(s.charAt(i));
			} else {
				sum -= keyValueMapping.get(s.charAt(i));
			}
		}
		return sum;
	}

}
