package leetcode.string.medium;

public class LC5LongestPalindromicSubstring {

	public static void main(String[] args) {

		String s = "abccbs";

		//Approach 1 find all substring which takes O(n square) and then check if each substring is a palindrome or not o(n)
		//.i.e., O(n square)*O(n)

		//Approach 2: Brute Same as Above
		System.out.println(longestPalindromeNew(s));

		//Approach 3
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {

		int n=s.length(), len=0;
		String sub="";

		for(int i=0;i<n;i++){
			int left=i, right=i;

			//odd string length
			while(left>=0 && right < n && s.charAt(left)==s.charAt(right)){
				if(right-left+1>len){
					len=right-left+1;
					sub=s.substring(left, right+1);
				}
				left--;
				right++;
			}

			left=i;
			right=i+1;
			//even string length
			while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
				if(right-left+1>len){
					len=right-left+1;
					sub=s.substring(left, right+1);
				}
				left--;
				right++;
			}
		}
		return sub;

		//TC:O(n square)
		//SC:O(n) if entire string is palindrome
	}

	public static String longestPalindromeNew(String s) {

		String palin="";
		for(int i=0;i<s.length();i++){
			int j=i;
			while(j<s.length()){
				if(isPalindrome(s,i,j)){
					if(palin.length() < s.substring(i,j+1).length())
						palin=s.substring(i,j+1);
				}
				j++;
			}
		}
		return palin;
		//TC:O(n square)
	}

	public static boolean isPalindrome(String s, int start, int end){
		while(start<end){
			if(s.charAt(start)!=s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
