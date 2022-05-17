package learningLogic.own;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the no whose factorial needs to be obtained:");
		int n=scan.nextInt();
		int fac=factorial(n);
		System.out.println("Factorial is :"+fac);

	}

	private static int factorial(int n) {
	if (n<=1)
		return 1;
	else
		return n* factorial(n-1);	
		
	}

}
