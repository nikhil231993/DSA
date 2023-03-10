package geeksForGeeks;

import java.util.Scanner;

public class palindromeString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string to check for palindrome: ");
		String s = scan.nextLine();
		int flag = 0;

		for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
			if (s.charAt(i) == s.charAt(j))
				continue;
			else {
				System.out.println("Not palindrome");
				flag = 1;
				break;
			}
		}

		if (flag == 0)
			System.out.println("palindrome");

		scan.close();
	}
}
