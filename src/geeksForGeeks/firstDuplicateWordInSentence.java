package geeksForGeeks;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class firstDuplicateWordInSentence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter the sentence: ");
		String s = scan.nextLine();
		String[] words = s.split(" ");
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		for (int i = 0; i < words.length; i++) {
			if (!lhs.contains(words[i])) {
				lhs.add(words[i]);
			} else
			{
				System.out.println("FIrst duplicate word is: " + words[i]);
				break;
			}
		}

		scan.close();
	}

}
