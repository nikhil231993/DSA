package leetcode.string.easy;

public class LC28FindFirstOccurrenceInAString {

	public static void main(String[] args) {

		String haystack = "test";
		String needle = "st";

		//Approach 1
		System.out.println(strStrBrute(haystack,needle));

		//Approach 2
		System.out.println(findOccurrence(haystack, needle));

		//Approach 3: Need to learn KMP algorithm https://www.youtube.com/watch?v=JoF0Z7nVSrA&ab_channel=NeetCode
	}

	private static int strStrBrute(String haystack, String needle) {

		return haystack.indexOf(needle);
	}

	private static int findOccurrence(String haystack, String needle) {

		int n=haystack.length(), m=needle.length();

		for(int i=0; i<n; i++){
			int k=i;
			if(haystack.charAt(i) == needle.charAt(0)){
				int j=0;
				while(k<n && j<m && haystack.charAt(k++)==needle.charAt(j++))
					if(j==m)
						return i;
			}
		}
		return -1;

		//TC:O(m*n)
	}
}
