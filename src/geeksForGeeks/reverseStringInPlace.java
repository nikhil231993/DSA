package geeksForGeeks;

import java.util.Scanner;

public class reverseStringInPlace {
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the string to reverse: ");
		String str=scan.nextLine();
		StringBuilder sb=new StringBuilder(str);
		char a=' ';
		int j=str.length()-1;
		for(int i=0;i<str.length()/2;i++)
		{
			a=str.charAt(i);
			
		    sb.setCharAt(i, str.charAt(j));
			sb.setCharAt(j, a);
			j--;
		}
		System.out.println(sb);
		scan.close();
	}

}
