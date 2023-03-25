package leetcode.array.easy;

import java.util.Scanner;

public class LC344ReverseString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String s = scan.nextLine();
		char[] charS = s.toCharArray();

		char[] reversedString = reverse(charS);
		System.out.println("Reversed string is: ");
		for (char value : reversedString)
			System.out.print(value);
		scan.close();
	}

	private static char[] reverse(char[] s) {
		for (int i = 0, j = s.length - 1; i < s.length / 2; i++, j--) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;

		}
		return s;
	}

}
