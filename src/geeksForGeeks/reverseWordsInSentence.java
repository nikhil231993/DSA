package geeksForGeeks;

import java.util.Scanner;

public class reverseWordsInSentence {
	
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter the sentence whise words are to be reversed: ");
		String str=scan.nextLine();
		String[] words=str.split(" ");
		System.out.println("Words in reverse order are: ");
		for(int i=words.length-1;i>=0;i--)
			System.out.println(words[i]);
		scan.close();
	}

}
