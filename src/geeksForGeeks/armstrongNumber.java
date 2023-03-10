package geeksForGeeks;

import java.util.Scanner;

public class armstrongNumber {

	public static void main(String[] args)

	{
		Scanner scan = new Scanner(System.in);
		System.out.println("NEter the number to check armstring number: ");
		int num = scan.nextInt();
		int original = num;
		int a = 0;
		int sum = 0;
		while (num > 0) {
			a = num % 10;
			sum = sum + a * a * a;
			num = num / 10;
		}
		if (original == sum)
			System.out.println("armstrong");
		else
			System.out.println("not armstring");

		scan.close();

	}

}
