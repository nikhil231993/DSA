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

		int left=0, right=s.length;
		while(left < right){
			char temp = s[right];
			s[right] = s[left];
			s[left] = temp;
			left++;
			right--;
		}
		return s;

		//TC:O(n/2)
		//SC:O(1)
	}
}
