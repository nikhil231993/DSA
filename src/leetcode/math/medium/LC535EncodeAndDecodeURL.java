package leetcode.math.medium;

import java.util.HashMap;

public class LC535EncodeAndDecodeURL {

	public static void main(String[] args) {

		String longUrl = "https://leetcode.com/problems/design-tinyurl";

		HashMap<String, String> shortToLong=new HashMap();
		HashMap<String, String> longToShort=new HashMap();
		System.out.println(encode(longUrl, longToShort, shortToLong));
	}

	private static String decode(String shortUrl,HashMap<String, String> longToShort,HashMap<String, String> shortToLong) {
		return shortToLong.get(shortUrl);
	}

	private static String encode(String longUrl, HashMap<String, String> longToShort, HashMap<String, String> shortToLong) {

		//https://leetcode.com/problems/encode-and-decode-tinyurl/solutions/1110551/js-python-java-c-easy-map-solution-w-explanation/?orderBy=most_votes
		if(longToShort.containsKey(longUrl))
			return longToShort.get(longUrl);

		String code=hash(longUrl);
		String shortUrl="http://tinyurl.com/"+code;

		while(shortToLong.containsKey(shortUrl)){
			code=hash(longUrl);
			shortUrl="http://tinyurl.com/"+code;
		}
		shortToLong.put(shortUrl, longUrl);
		longToShort.put(longUrl, shortUrl);
		return shortUrl;
	}

	public static String hash(String url){

		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		StringBuilder sb=new StringBuilder();
		for(int i=0;i<6;i++){
			int index=(int)((Math.random()*1000) % 62);
			sb.append(str.charAt(index));
		}
		return sb.toString();
	}
}
