package leetcode.string.easy;

public class LC14LongestCommonPrefix {

	public static void main(String[] args) {

		String[] s = new String[] { "flower", "flow", "flight" };

		//Approach 1
		System.out.println(longestCommonPrefix(s));

		//Approach 2
		System.out.println(longestCommonPrefixWithWhile(s));

		//Approach 3: Binary Search
		System.out.println(longestCommonPrefixBS(s));
	}

	private static String longestCommonPrefixBS(String[] s) {


		if(s==null || s.length==0)
			return "";
		int n=s.length;
		int minLen=Integer.MAX_VALUE;

		for(int i=0;i<n;i++){
			minLen=Math.min(minLen, s[i].length());
		}

		int low=0;
		int high=minLen;

		while(low<=high){
			int mid=low+(high-low)/2;
			if(isPrefix(mid, s))
				low=mid+1;
			else
				high=mid-1;
		}
		return s[0].substring(0, (low+high)/2);
	}

	private static boolean isPrefix(int mid, String[] s) {

		int n=s.length;
		String prefix=s[0].substring(0, mid);
		for(int i=1; i<n; i++){
			if(!s[i].startsWith(prefix)) //if(s[i].indexOf(prefix)!=0)
				return false;
		}
		return true;
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
