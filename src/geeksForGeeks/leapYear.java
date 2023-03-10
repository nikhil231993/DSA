package geeksForGeeks_1;

import java.util.Scanner;

public class leapYear {
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the year to be checked: ");
		int year=scan.nextInt();
		if(year%4==0)
		{
			if(year%100==0)
			{
				if(year%400==0)
				{
					System.out.println("leap year");
				}
				else
					System.out.println("not a leap year");
				
			}else
				System.out.println("leap year");
			
		}else
			System.out.println("not aleap year");
		scan.close();
	}

}
