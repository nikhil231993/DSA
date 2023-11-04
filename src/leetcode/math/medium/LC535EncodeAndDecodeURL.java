package leetcode.math.medium;

import java.util.HashMap;

public class LC535EncodeAndDecodeURL {

	public static void main(String[] args) {

		String longUrl = "https://leetcode.com/problems/design-tinyurl";
		HashMap<String, String> urlMapping = new HashMap();
		HashMap<String, String> code = new HashMap();
		System.out.println(decode(longUrl, urlMapping, code));
	}

	private static String decode(String longUrl,HashMap<String, String> urlMapping,HashMap<String, String> code) {

		//https://leetcode.com/problems/encode-and-decode-tinyurl/solutions/1110551/js-python-java-c-easy-map-solution-w-explanation/?orderBy=most_votes
		if (urlMapping.containsKey(longUrl))
			return urlMapping.get(longUrl);

		String hash = hashFunction();

		while (code.containsKey(hash))
			hash = hashFunction();
		String shortUrl = "http://tinyurl.com/" + hash;
		urlMapping.put(longUrl, shortUrl);
		code.put(shortUrl, longUrl);
		return urlMapping.get(longUrl);
	}

	private static String encode(String hash, HashMap<String, String> urlMapping, HashMap<String, String> code) {
		return code.get(hash);
	}

	private static String hashFunction() {
		String s ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		char[] ch=new char[6];
		for(int i=0;i<ch.length;i++) {
			ch[i] = s.charAt((int) (Math.random() * 1000 % 62));
		}
		String hashed=new String(ch);
		return hashed;
	}
}
