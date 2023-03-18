package learningLogic.recursion.striver;

import java.util.Scanner;

public class V4Palindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		System.out.println(palindrome(s, 0));

		scan.close();

	}

	private static boolean palindrome(String s, int pos) {

		if (pos < s.length() - 1 / 2) {
			if (s.charAt(pos) == s.charAt(s.length() - 1 - pos)) {
				return palindrome(s, pos + 1);
			} else {
				return false;
			}
		}
//		if (pos == s.length() - 1 / 2)
//			System.out.println("Palindrome");
		return true;

		// SC:O(n)
		// TC:O(n)

	}

}
