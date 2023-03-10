package geeksForGeeks;

import java.util.Scanner;

public class gcd_3 {
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the numbers whose gcd is to be foudn out: ");
		int a=scan.nextInt();
		int b=scan.nextInt();
		while(a!=b)
		{
			if(a>b)
				a=a-b;
			else if(a<b)
				b=b-a;
		}
	
		System.out.println("gcd of two numbers are: "+a);
		scan.close();
	}

}
