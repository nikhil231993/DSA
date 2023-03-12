package geeksForGeeks;

import java.util.Scanner;

public class gcd_2 {

	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the numbers whose gcd is to be foudn out: ");
		int a=scan.nextInt();
		int b=scan.nextInt();
		System.out.println("gcd of teh numbers is: "+gcd(a,b));
		scan.close();
	}

	 static int gcd(int a, int b) {
		 	if(b==0)
		 		return a;
	
		return gcd(b,a%b);
	}
}
