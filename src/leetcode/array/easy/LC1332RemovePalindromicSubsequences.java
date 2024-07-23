package leetcode.array.easy;

import java.util.Scanner;

public class LC1332RemovePalindromicSubsequences {

	public static void main(String[] args) {

		System.out.println("Enter string to check: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		System.out.println(palindrome(s));
	}

	private static int palindrome(String s) {

		if (s.length() == 0 || s.trim().length() == 0)
			return 0;
		int i=0;
		while (i < s.length() / 2) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return 2;
			}
			i++;
		}
		return 1;

		//TC:O(n)
		//SC:O(1)
	}
}
