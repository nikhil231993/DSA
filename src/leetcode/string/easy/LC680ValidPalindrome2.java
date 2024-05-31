package leetcode.string.easy;

public class LC680ValidPalindrome2 {

	public static void main(String[] args) {

		String str = "abc";
		System.out.println(validPalindrome(str));
	}

	public static boolean validPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
//				return isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1);
				// can also be return as below
				if (isPalindrome(s, start + 1, end))
					return true;
				else if (isPalindrome(s, start, end - 1))
					return true;
				else
					return false;
			}
		}
		return true;

		//TC:O(n)
		//SC:O(1)
	}

	private static boolean isPalindrome(String s, int start, int end) {

		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			}else 
				return false;
		}
		return true;
	}
}
