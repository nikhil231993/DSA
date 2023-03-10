package geeksForGeeks;

import java.util.Scanner;

public class integerPalindrome {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number ");
		int num=scan.nextInt();
		int original=num;
		int reversednum=0;
		int i=0;
		int a=0;
		while(num>0)
		{
		a=num%10;
		reversednum+=a*Math.pow(10,i);//reversednum=reversednum*10+a
		i++;
		num=num/10;
		}
		System.out.println(reversednum);
		if(original==reversednum)
			System.out.println("palindrome");
		else
			System.out.println("not an palindrom");
		scan.close();
				
				
	}

}
