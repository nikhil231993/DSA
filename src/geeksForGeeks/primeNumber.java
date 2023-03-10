package geeksForGeeks;

import java.util.Scanner;

public class primeNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("ENter the number to chec if it si prime number: ");
		int num = scan.nextInt();
		int i = 0;
		for (i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				System.out.println("not prime");
				break;
			} else
				continue;
		}
		if (i == num / 2)
			System.out.println("prime");

		scan.close();
	}
}
