package leetcode.math.easy;

import java.util.HashSet;

public class LC202HappyNumber {

	public static void main(String[] args) {

		int n = 19;

		//Approach 1
		System.out.println(isHappy(n));

		//Approach 2 better
		System.out.println(isHappyBetter(n));
	}

	private static boolean isHappyBetter(int n) {

		 int slow=n;
		 int fast=n;
		 do{
		 	 slow=squareDigits(slow);
			 fast=squareDigits(squareDigits(fast));

		 }while(slow!=fast);

		 if(slow==1)
		 	return true;
		 return false;

			// SC:O(1)
			// TC:(logn) where log n is the time taken to find no of digits in a number
	}

	 public static int squareDigits(int n) {

		 int sum = 0;
		 while (n != 0) {
			 int digit = n % 10;
			 sum = sum + digit * digit;
			 n = n / 10;
		 }
		 return sum;
	 }

	public static boolean isHappy(int n) {

		HashSet<Integer> h = new HashSet();

		while (!h.contains(n)) {

			h.add(n);
			int sum = 0;
			while (n != 0) {
				int digit = 0;
				digit = n % 10;
				sum += digit * digit;
				n = n / 10;
			}
			n = sum;
		}
		if (n == 1)
			return true;
		return false;

		// SC:O(log n)
		// TC:(logn) where log n is the time taken to find no of digits in a number
	}
}
