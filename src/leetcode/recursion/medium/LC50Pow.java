package leetcode.recursion.medium;

public class LC50Pow {

	public static void main(String[] args) {
		double x = 2.0000;
		int n = -2147483648;

		System.out.println(myPow(x, n));
//
//		System.out.println(pow(x, n));
//
//		System.out.println(powLog(x, n));

		System.out.println(powBinaryExponentiation(x, n));

		System.out.println(powBinaryExponentiationUsingBit(x, n));
	}

	private static double powBinaryExponentiationUsingBit(double x, int n) {
		double ans = 1.0;
		long nn = n;
		if (n < 0) {
			nn = -nn;
			x = 1 / x;
		}

		while (nn > 0) {
			if ((nn & 1) != 0) {
				ans = ans * x;
			}

			x = x * x;
			nn = nn >>> 1;
		}
		return ans;
	}

	private static double powBinaryExponentiation(double x, int n) {
		double ans = 1.0;
		long nn = n;

		if (nn < 0)
			nn = -1 * nn;

		while (nn > 0) {
			if (nn % 2 == 1) {
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

	private static double powLog(double x, int n) {
		if(n==0)
			return 1;
		long temp = (long) powLog(x, n / 2);

		if (n % 2 == 1)
			return temp * temp * x;

		return temp * temp;

		// SC:O(log n)
		// TC:O(log n)
	}

	private static double pow(double x, int n) {
		if(n==0)
			return 1;
		return x * pow(x, n - 1);
		// SC:O(n)
		// TC:O(n)
	}

	public static double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n%2 == 0) {
			return myPow(x*x, n/2);
		}
		if (n%2 == 1) {
			return x * myPow(x, n-1);
		}
		return 1/ myPow(x, -n);
	}

}
