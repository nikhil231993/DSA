package learningLogic.recursion;

import java.util.Scanner;

public class V4Palindrome {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		palindrome(s, 0);

		scan.close();

	}

	private static void palindrome(String s, int pos) {

		if (pos < s.length() - 1 / 2) {
			if (s.charAt(pos) == s.charAt(s.length() - 1 - pos)) {
				palindrome(s, pos + 1);
			} else {
				System.out.println("Not palindrome");
			}
		}
		if (pos == s.length() - 1 / 2)
			System.out.println("Palindrome");

	}

}
