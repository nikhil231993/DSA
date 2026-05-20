package leetcode.array.easy;

import java.util.Scanner;

public class LC1332RemovePalindromicSubsequences {

	public static void main(String[] args) {

		System.out.println("Enter string to check: ");

		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();

		System.out.println(palindrome(s));

		System.out.println(palindromeSelf(s));
	}

	private static int palindrome(String s) {

		int n=s.length();
		if (n == 0 || s.trim().isEmpty())
			return 0;
		int i=0;
		while (i < n / 2) {
			if (s.charAt(i) != s.charAt(n - 1 - i)) {
				return 2;
			}
			i++;
		}
		return 1;

		//TC:O(n)
		//SC:O(1)
	}

	public static int palindromeSelf(String s) {

		int n=s.length();
		int left=0;
		int right=n-1;
		while(left<=right){

			if(s.charAt(left)!=s.charAt(right))
				return 2;
			left++;
			right--;
		}
		return 1;
	}
}
