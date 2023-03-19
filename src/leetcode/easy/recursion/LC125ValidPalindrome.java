package leetcode.easy.recursion;

public class LC125ValidPalindrome {

	public static void main(String[] args) {
		String s = "race a car";
//		/System.out.println(validPalindrome(s));
		System.out.println(validPalindromeInbuilt(s));

	}

	private static boolean validPalindromeInbuilt(String s) {

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {

			while (!Character.isLetterOrDigit(s.charAt(start)) && start < end) {
				start++;
			}
			while (!Character.isLetterOrDigit(s.charAt(end)) && start < end) {
				end--;
			}
			if (start < end && !(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end)))) {
				return false;
			}
			start++;
			end--;
		}
		return true;

	}

	public static boolean validPalindrome(String s) {

		String str = s.toLowerCase();

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {

			while (!(((int) str.charAt(start) >= 97 && (int) str.charAt(start) <= 122)
					|| ((int) str.charAt(start) >= 48 && (int) str.charAt(start) <= 57)) && start < end) {
				start++;
			}
			while (!(((int) str.charAt(end) >= 97 && (int) str.charAt(end) <= 122)
					|| ((int) str.charAt(end) >= 48 && (int) str.charAt(end) <= 57)) && start < end) {
				end--;
			}
			if (start < end && !(str.charAt(start) == str.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
