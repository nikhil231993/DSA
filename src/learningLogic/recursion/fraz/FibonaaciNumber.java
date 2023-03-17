package learningLogic.recursion.fraz;

public class FibonaaciNumber {

	public static void main(String[] args) {
		int n = 8;

		System.out.println(fibo(n));

		fibonacciSeries(n);

	}

	private static void fibonacciSeries(int num) {
		int n1 = 0;
		int n2 = 1;
		int count = 0;
		int n = 0;
		while (num != count) {
		
			System.out.println(n1+" " );
			n = n1 + n2;
			n1 = n2;
			n2 = n;

			count++;
			}
	}

	public static int fibo(int n) {
		if (n == 1 || n == 0)
			return 1;
		return fibo(n - 1) + fibo(n - 2);
	}

}
