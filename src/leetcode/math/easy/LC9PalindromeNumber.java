package leetcode.math.easy;

public class LC9PalindromeNumber {

	public static void main(String[] args) {

		int x = 2147447412;

		//Approach 1:
		System.out.println(isPalindromeUsingString(x));

		//Approach 2:
		System.out.println(isPalindrome(x));
	}

	private static boolean isPalindromeUsingString(int x) {

		if(x<0) return false;
		String str=String.valueOf(x);
		int length=str.length();

		for(int i=0;i<length/2;i++){
			if(str.charAt(i)!=str.charAt(length-i-1))
				return false;
		}
		return true;
	}

	public static boolean isPalindrome(int x) {

		if (x < 0)
			return false;
		int y = x;
		int num = 0;
		while (x != 0) {
			if(num>Integer.MAX_VALUE/10 || num<Integer.MIN_VALUE/10)//Not mandatory
				return false;                                       //Not mandatory
			num = num * 10 + x % 10;
			x = x / 10;
		}
		if (y == num)
			return true;
		else
			return false;

		// TC:O(n) where n is the no of digits in no x
		// SC:O(1)
	}
}
