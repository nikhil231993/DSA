package leetcode.recursion.medium;

public class LC50Pow {

	public static void main(String[] args) {
		int x = 2;
		int n = 15;

		// System.out.println(pow(x, n));

		// System.out.println(powLog(x, n));

		// System.out.println(powBinaryExponentiation(x, n));

		System.out.println(powBinaryExponentiationUsingBit(x, n));
	}

	private static double powBinaryExponentiationUsingBit(int x, int n) {
		double ans = (long) 1.0;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}

		while (n > 0) {
			if ((n & 1) != 0) {
				ans = ans * x;
			}

			x = x * x;
			n = n >>> 1;
		}
		return ans;
	}

	private static double powBinaryExponentiation(int x, int n) {
		double ans = (double) 1.0;
		long nn = n;

		if (nn < 0)
			nn = -1 * nn;

		while (nn > 0) {
			if (n % 2 == 1) {
				ans = ans * x;
				nn = nn - 1;
			} else {
				x = x * x;
				nn = nn / 2;
			}
		}

		if (n < 0)
			ans = (double) (1) / (double) (ans);
		return ans;
	}

	private static long powLog(int x, int n) {
		if(n==0)
			return 1;
		long temp = (long) powLog(x, n / 2);

		if (n % 2 == 1)
			return temp * temp * x;

		return temp * temp;

		// SC:O(log n)
		// TC:O(log n)
	}

	private static long pow(int x, int n) {
		if(n==0)
			return 1;
		return x * pow(x, n - 1);
		// SC:O(n)
		// TC:O(n)
	}

}
