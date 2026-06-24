package leetcode.array.easy;

public class LC14LongestCommomPrefix {

	public static void main(String[] args) {

		String[] strs = new String[] { "rdog", "racecar", "car" };

		//Approach 1:
		System.out.println(fetchLongestCommonSequence(strs));

		//Approach 2:
		System.out.println(fetchLongestCommon(strs));

		//Approach 3:
		System.out.println(longestCommonPrefixBinarySearch(strs));
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

	private static String fetchLongestCommonSequence(String[] strs) {

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

		for (int i = 1; i <strs.length; i++) {
			if (strs[i].length() < min) {
				min = strs[i].length();
			}
		}
		return min;
	}

	private static String longestCommonPrefixBinarySearch(String[] strs) {
		int n=strs.length;

		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
			min=Math.min(min, strs[i].length());

		int low=0, high=min;
		int ans=0;
		while(low<=high){
			int mid=low+(high-low)/2;
			if(isPrefix(mid, strs)){
				ans=mid;
				low=mid+1;
			}else{
				high=mid-1;
			}
		}
		return strs[0].substring(0, ans);
	}

	private static boolean isPrefix(int index, String[] s){
		String prefix=s[0].substring(0, index);
		int n=s.length;
		for(int i=1;i<n;i++){
			if(s[i].indexOf(prefix)!=0)
				return false;
		}
		return true;
	}
}
