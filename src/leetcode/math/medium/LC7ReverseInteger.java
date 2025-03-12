package leetcode.math.medium;

public class LC7ReverseInteger {

	public static void main(String[] args) {

		int n = -123;
		n=2147483647;
		//n=1534236469;
		System.out.println(reverseInteger(n));
	}

	private static int reverseInteger(int n) {

		int ans = 0;
		while (n != 0) {
			if(ans >  Integer.MAX_VALUE/10 || ans < Integer.MIN_VALUE/10)
				return 0;
			ans = ans * 10 + n % 10;
			n = n / 10;
		}
		return ans;

		//TC:O(log bas10 n) where n is the length of the integer
		//When we divide any number continuously by any digit the TC will be base to that number
		//SC:O(1)
	}
}
