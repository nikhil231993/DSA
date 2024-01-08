package learningLogic.recursion.fraz;

public class CheckPalindrome {

	public static void main(String[] args) {
		String s = "sss";

		System.out.println(checkPalindromeIteratively(s));
		System.out.println(checkPalindromeRecursively(s, 0));

	}

	private static boolean checkPalindromeRecursively(String s,int start) {

		if (start < s.length() - 1 / 2) {
			if (s.charAt(start) == s.charAt(s.length() - 1 - start)) {
				return checkPalindromeRecursively(s, start + 1);

			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean checkPalindromeIteratively(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;

			} else {
				return false;
			}
		}
		return true;
	}
}
