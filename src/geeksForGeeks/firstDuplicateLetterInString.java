package geeksForGeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class firstDuplicateLetterInString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string of which first duplicate is to be found: ");
		String s = scan.nextLine();
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (hm.containsKey(s.charAt(i))) {
				System.out.println("first duplicate letter is: " + s.charAt(i));
				break;
			} else {
				hm.put(s.charAt(i), 1);
			}
		}
		scan.close();

	}

}
