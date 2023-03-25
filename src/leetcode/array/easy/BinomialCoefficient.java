package leetcode.array.easy;

import java.util.Scanner;

public class BinomialCoefficient {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		System.out.println(binomialCoefficient(n, k));
		scan.close();

	}

	private static int binomialCoefficient(int n, int k) {
		int res = 1;
		if (k < n - k)
			k = n - k;
		for (int i = 0; i < k; i++) {
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
		// TC:0(k)
	}

}
