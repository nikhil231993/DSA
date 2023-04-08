package learningLogic.recursion.striver;

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

		//TC:O(2 raised to N) exponential like for 4 it is 9 actually but near about exponential in nature
		//SC:O(2 raise to N) stack space
	}

}
