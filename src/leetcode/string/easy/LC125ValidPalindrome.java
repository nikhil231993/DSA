package leetcode.string.easy;

public class LC125ValidPalindrome {

	public static void main(String[] args) {

		String s = "1A man, a plan, a canal: Panama1";

		//Approach 1 using ASCII
		System.out.println(validPalindromeBruteForce(s));

		//Approach 2
		System.out.println(validPalindromeInBuiltLibrary(s));
	}

	private static boolean validPalindromeInBuiltLibrary(String s) {

		String str = s.toLowerCase();
		
		int start=0;
		int end=str.length()-1;
		
		while(start<end) {
			while (start < end && !Character.isLetterOrDigit(str.charAt(start)))
				start++;
			while (start < end && !Character.isLetterOrDigit(str.charAt(end)))
				end--;
			if (start < end && !(str.charAt(start) == str.charAt(end)))
				return false;
			start++;
			end--;
		}
		return true;
	}

	private static boolean validPalindromeBruteForce(String s) {

		String str = s.toLowerCase();
		
		int start=0, end=str.length()-1;
		
		while (start < end) {
			while (start < end && !(((int) str.charAt(start) >= 97) && ((int) str.charAt(start) <= 122)
					|| ((int) str.charAt(start) >= 48) && ((int) str.charAt(start) <= 57))) {
				start++;
			}

			while (start < end && !(((int) str.charAt(end) >= 97) && ((int) str.charAt(end) <= 122)
					|| ((int) str.charAt(end) >= 48) && ((int) str.charAt(end) <= 57))) {
				end--;
			}

			if (start < end && !(str.charAt(start) == str.charAt(end)))
				return false;
			start++;
			end--;
		}
		return true;

		// SC:O(1)
		// TC:O(n)
	}
}
