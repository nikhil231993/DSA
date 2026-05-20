package leetcode.math.medium;

public class LC343IntegerBreak {

	public static void main(String[] args) {

		int n = 20;
		System.out.println(integerBreak(n));
	}

	private static int integerBreak(int n) {

		if (n <=3)
			return n - 1;

		int product = 1;
		while (n > 4) {
			n = n - 3;
			product = product * 3;
		}
		return n * product;

		//TC:O(n)
		//SC:O(1)
	}
}
