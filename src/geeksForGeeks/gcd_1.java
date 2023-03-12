package geeksForGeeks;

import java.util.Scanner;

public class gcd_1 {
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the two numbers: ");
		int a=scan.nextInt();
		int b=scan.nextInt();
		System.out.println("gcd of numbers are: "+ gcd(a,b));
		scan.close();
	}

	 static int gcd(int a, int b) {
	if(a==0)
		return b;
	else if (b==0)
		return a;
	else if(a==b)
		return a;
	
	if(a>b)
		return gcd((a-b),b);
	
		return gcd(a,(b-a));
	}

}
