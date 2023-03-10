package geeksForGeeks;

import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number till where fiboncacci is to be found out: ");
		int num = scan.nextInt();
		int a = 0;
		int b = 1;
		System.out.println(a);
		System.out.println(b);
		int c = 0;
		for (int i = 0; i < num; i++) {
			

			c = a + b;
			System.out.println(c);
			a = b;
			b = c;

		}
		scan.close();

	}
}
