package leetcode.string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49GroupedAnagrams {

	public static void main(String[] args) {
		List<String> str = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");

		List<List<String>> result = groupedAnagrams(str);
		System.out.println(result);

		List<List<String>> result1 = groupedAnagramsSUsingHash(str);
		System.out.println(result1);
	}

	private static List<List<String>> groupedAnagramsSUsingHash(List<String> str) {
		List<List<String>> list = new ArrayList();

		HashMap<String, List<String>> map = new HashMap();
		for (String s : str) {
			char[] ch = new char[26];
			for (int i = 0; i < s.length(); i++) {
				ch[s.charAt(i) - 'a']++;
			}
			String key = new String(ch);
			System.out.println(key);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList());
			}
			map.get(key).add(s);
			
		}
		list.addAll(map.values());
		return list;

		// TC:O(NK) where N is the total no of strings and K is the avg length of each
		// string
		// SC:O(N)

	}

	private static List<List<String>> groupedAnagrams(List<String> str) {
		List<List<String>> list = new ArrayList();
		HashMap<String, List<String>> map = new HashMap();

		for (String s : str) {
			char[] c = s.toCharArray();
			Arrays.sort(c);
			String sortedKey = new String(c);

			if (!map.containsKey(sortedKey)) {
				map.put(sortedKey, new ArrayList());
			}
			
			map.get(sortedKey).add(s);
		}
		list.addAll(map.values());
		return list;

		// TC:O(NKlogK) n total no of strings k length of each string as we are sorting
		// the strings
	}

}
