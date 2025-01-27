package leetcode.string.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC13RomanToInteger {

	public static void main(String[] args) {

		String s = "IV";

		//Approach 1
		System.out.println(romanToIntegerUsingMap(s));

		//Approach 2
		System.out.println(romanToIntegerWithoutUsingMap(s));

		//Approach 3: Best
		System.out.println(romanToIntOptimized(s));

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

		int sum = 0, num = 0, forward=0;

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

		//TC:O(n)
		//SC:O(1)
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

			if (keyValueMapping.get(s.charAt(i)) < keyValueMapping.get(s.charAt(i + 1))) {
				sum -= keyValueMapping.get(s.charAt(i));
			} else {
				sum += keyValueMapping.get(s.charAt(i));
			}
		}
		return sum;

		//TC:O(n);
		//SC:O(constant values given in question)
	}

	public static int romanToIntOptimized(String s) {

		HashMap<Character, Integer> map=new HashMap<>();
		map.put('I',1);
		map.put('V',5);
		map.put('X',10);
		map.put('L',50);
		map.put('C',100);
		map.put('D',500);
		map.put('M',1000);

		int num=0;
		int prev=0;
		int sum=0;
		int n=s.length();
		for(int i=n-1;i>=0;i--){
			num=map.get(s.charAt(i));

			if(num>=prev){
				sum+=num;
			}else{
				sum-=num;
			}
			prev=num;
		}
		return sum;

		//Time complexity : O(1).
		//As there is a finite set of roman numerals, the maximum number possible number can be 3999, which in roman numerals is MMMCMXCIX. As such the time complexity is O(1).
		//If roman numerals had an arbitrary number of symbols, then the time complexity would be proportional to the length of the input, i.e. O(n). This is assuming that looking up the value of each symbol is O(1).
		//Space complexity : O(1).
		//Because only a constant number of single-value variables are used, the space complexity is O(1).
	}
}
