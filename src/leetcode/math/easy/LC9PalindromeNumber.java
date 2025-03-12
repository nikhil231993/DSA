package leetcode.math.easy;

public class LC9PalindromeNumber {

	public static void main(String[] args) {

		int x = 2147483647;

		//Approach 1:
		System.out.println(isPalindromeUsingString(x));

		//Approach 2:
		System.out.println(isPalindrome(x));

		//Approach 3: Optimised
		System.out.println(isPalindromeLeetcode(x));
	}

	public static boolean isPalindromeLeetcode(int x) {

		// Special cases:
		// As discussed above, when x < 0, x is not a palindrome.
		// Also if the last digit of the number is 0, in order to be a palindrome,
		// the first digit of the number also needs to be 0.
		// Only 0 satisfy this property.
		if (x < 0 || (x % 10 == 0 && x != 0)) {
			return false;
		}

		int revertedNumber = 0;
		while (x > revertedNumber) {
			revertedNumber = revertedNumber * 10 + (x % 10);
			x /= 10;
		}

		// When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
		// For example when the input is 12321, at the end of the while loop we get x = 12,
		// revertedNumber = 123,
		// since the middle digit doesn't matter in palindrome(it will always equal to itself), we
		// can simply get rid of it.
		return x == revertedNumber || x == revertedNumber / 10;

		//TC:O(log base 10 to x) where n is the no of digits in no x
		//SC:O(1)
	}

	private static boolean isPalindromeUsingString(int x) {

		if(x<0)
			return false;
		String str=String.valueOf(x);
		int length=str.length();

		for(int i=0;i<length/2;i++){
			if(str.charAt(i)!=str.charAt(length-i-1))
				return false;
		}
		return true;
	}

	public static boolean isPalindrome(int x) {

		if(x==0) return true;

		if (x < 0  || (x%10)==0)
			return false;
		int y = x;
		int num = 0;
		while (x != 0) {
			if(num > Integer.MAX_VALUE/10 || num < Integer.MIN_VALUE/10)//Not mandatory
				return false;                                       //Not mandatory
			num = num * 10 + x % 10;
			x = x / 10;
		}
		return  y == num;

		//TC:O(log base 10 to x) where n is the no of digits in no x
		//SC:O(1)
	}
}
