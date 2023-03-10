package geeksForGeeks_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class repeatedCharactersInString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = scan.nextLine();
		System.out.println(str);
		Map<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			if (hm.containsKey(str.charAt(i))) {
				hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
			} else {
				hm.put(str.charAt(i), 1);
			}
		}

		Set<Map.Entry<Character, Integer>> s = hm.entrySet();
		System.out.println("Duplicate values are: ");
		for (Entry<Character, Integer> m : s) {
			if (m.getValue() >= 2) {
				System.out.println(m.getKey());
			}
		}

		scan.close();
	}
}
