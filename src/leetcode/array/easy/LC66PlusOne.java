package leetcode.array.easy;

import java.util.Scanner;

public class LC66PlusOne {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int n = scan.nextInt();

		String c = String.valueOf(n);

		//Below is just to convert a Number to Array
		int[] digits = new int[c.length()];
		int i = c.length() - 1;
		while (n != 0 && i >= 0) {
			int rem = n % 10;
			n = n / 10;
			digits[i] = rem;
			i--;
		}

		//Approach 1
		int[] result = plusOne(digits);
		for (int k = 0; k < result.length; k++)
			System.out.println(result[k]);
		scan.close();
	}

	private static int[] plusOne(int[] digits) {

		for (int i = digits.length - 1; i >= 0; i--) {
			if(digits[i]<9) {
				digits[i]++;
				return digits;
			}
			digits[i]=0;
		}
		int[] new_number = new int[digits.length + 1];
		new_number[0] = 1;
		return new_number;

		//TC:O(n)
		//SC:O(1)
	}
}
