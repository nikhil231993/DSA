package geeksForGeeks;

import java.util.Scanner;

public class reverseEachWordsInString_1 {
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the sentence of which words needs to be reversed: ");
		String str=scan.nextLine();
		String[] words=str.split(" ");
		String s="";
		for(int i=0;i<words.length;i++)
		{
			for(int j=words[i].length()-1;j>=0;j--)
			{
				s+=words[i].charAt(j);
			}
			s+=" ";
		}
		
		System.out.println("Reversed string is:"+s);
		scan.close();
	}

}
