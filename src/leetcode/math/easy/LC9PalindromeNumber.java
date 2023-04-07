package leetcode.math.easy;

public class LC9PalindromeNumber {

	public static void main(String[] args) {
		int x = -121;
		System.out.println(isPalindrome(x));

	}

	public static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int y = x;
		int num = 0;
		while (x != 0) {
			num = num * 10 + x % 10;
			x = x / 10;
		}

		if (y == num)
			return true;
		else
			return false;

		// TC:O(n) where n is the no of digitd in no x
		// SC:O(1)

	}

}
