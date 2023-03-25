package leetcode.array.easy;

import java.util.Scanner;

public class CountDigitsInANumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(countDigits(n));

	}

	private static int countDigits(int n) {
		int temp = 1;
		int count = 0;
		while (temp <= n) {
			temp = temp * 10;
			count++;
		}
		return count;
	}

}
