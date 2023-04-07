package leetcode.math.medium;

public class LC7ReverseInteger {

	public static void main(String[] args) {
		int n = -123;
		System.out.println(reverseInteger(n));

	}

	private static int reverseInteger(int n) {

		int ans = 0;
		while (n != 0) {
			
			if(ans>  Integer.MAX_VALUE || ans<Integer.MIN_VALUE)
				return 0;
			ans = ans * 10 + n % 10;
			n = n / 10;
		}
		return ans;

		// TC:O(n) where n is the length of the integer
		// SC:O(1)
	}

}
