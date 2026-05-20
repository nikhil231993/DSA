package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

public class LC1624SubstringBetweenEqualCharacters {

	public static void main(String[] args) {

		String s = "abca";
		System.out.println(maxLengthBetweenEqualCharacters(s));
		System.out.println(lengthOfLargetSubstring(s));
	}

	private static int maxLengthBetweenEqualCharacters(String s) {
		int n=s.length();
		int max=-1;
		for(int i=0;i<n-1;i++){
			for(int j=1;j<n;j++){
				if(s.charAt(i)==s.charAt(j)){
					max=Math.max(max, j-i-1);
				}
			}
		}
		return max;
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

	private int maxLengthBetweenEqualCharactersAlternative(String s) {
		int n=s.length();
		int max=-1;
		Map<Character, Integer> map=new HashMap();
		for(int i=0;i<n;i++){
			if(map.containsKey(s.charAt(i)))
				max=Math.max(max, i-map.get(s.charAt(i))-1);
			else
				map.put(s.charAt(i), i);
		}
		return max;
	}
}
