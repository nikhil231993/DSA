package geeksForGeeks;

import java.util.Scanner;

public class checkTwoStringAreAnagram {
	
	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the 1st string: ");
		String s1 = scan.nextLine();
		System.out.println("Enter the 2nd string: ");
		String s2 = scan.nextLine();
		int[] sr1 = new int[256];
		int[] sr2 = new int[256];
		int i;
		if (s1.length() != s2.length())
			System.out.println("Not an anagram");
		else {
			for (i = 0; i < s1.length(); i++) { 
				sr1[s1.charAt(i)]++;
				sr2[s2.charAt(i)]++;

			}
			int flag = 0;
			for (i = 0; i < sr1.length; i++) {
				if (sr1[i] != sr2[i]) {
					System.out.println("not an angaram");
					flag = 1;
					break;

				}
			}
			if (flag == 0)
				System.out.println("anagram");
			else
				System.out.println("not a angarm");
		}
		scan.close();

	
	}

}
