package learningLogic.own;

import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the depth: ");
		int n = 9;
		System.out.println(fibonacci(n));
	}

	private static int fibonacci(int n) {
		if (n <= 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);

	}

}
