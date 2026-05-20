package leetcode.string.easy;

public class LC125ValidPalindrome {

	public static void main(String[] args) {

		String s = "1A man, a plan, a canal: Panama1";

		//Approach 1 using ASCII
		System.out.println(isPalindrome(s));

		//Approach 2
		System.out.println(validPalindromeInBuiltLibrary(s));

		//Approach 3
		System.out.println(isPalindromeOptimized(s));
	}

	private static boolean validPalindromeInBuiltLibrary(String s) {

		String str = s.toLowerCase();
		int start=0, end=str.length()-1;
		
		while(start < end) {
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

	private static boolean isPalindrome(String s) {

		int n=s.length(), left=0, right=n-1;
		s=s.toLowerCase();

		while(left<right){
			while(left < right && !((s.charAt(left)>=97 && s.charAt(left)<=122) ||(s.charAt(left)>=65 && s.charAt(left)<=90)|| (s.charAt(left)>=48 && s.charAt(left)<=57)))
				left++;
			while(left < right && !((s.charAt(right)>=97 && s.charAt(right)<=122) ||(s.charAt(right)>=65 && s.charAt(right)<=90) || (s.charAt(right)>=48 && s.charAt(right)<=57)))
				right--;

			if(s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
		//SC:O(1)
		//TC:O(n)
	}

	private static boolean isPalindromeOptimized(String s) {
		int n=s.length(), left=0, right=n-1;
		while(left<right){
			while(left < right && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(left))))
				left++;
			while(left < right && !Character.isLetterOrDigit(Character.toLowerCase(s.charAt(right))))
				right--;

			if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
