package geeksForGeeks;

import java.util.Scanner;

public class reverseString {

	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the String to reverse: ");
		String s=scan.nextLine();
		StringBuffer sb=new StringBuffer();
		for(int i=s.length()-1;i>=0;i--)
			sb.append(s.charAt(i));
		System.out.println("String is: "+sb);
		scan.close();
		
	}

}
