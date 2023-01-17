package learningLogic.recursion;

public class V5FibonacciNumber {

	public static void main(String[] args) {
		int sum = fibonacciNumber(4);
		System.out.println(sum);
	}

	private static int fibonacciNumber(int n) {
//		if (n == 0)
//			return 0;
		if (n <= 1)
			return n;
		return fibonacciNumber(n - 1) + fibonacciNumber(n - 2);

		// TC:O(2 raised to N) exponential
	}

}
