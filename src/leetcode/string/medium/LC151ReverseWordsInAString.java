package leetcode.string.medium;

import java.util.Stack;

public class LC151ReverseWordsInAString {

	public static void main(String[] args) {
		String s = "      hello world  ";

		//Approach 1
		System.out.println(reverseWords(s));

		//Approach 2
		System.out.println(reverseWordsInPlace(s));
	}

	private static String reverseWordsInPlace(String s) {
		int i = s.length() - 1;
		int j = 0;
		String r = "";
		while(i>=0) {
			while(i>=0 && s.charAt(i)==' ')
				i--;
			j=i;
			while(i>=0 && s.charAt(i)!= ' ')
				i--;
			if(r.isEmpty())
			{
				r=r.concat(s.substring(i+1,j+1));
			}else {
				r=r.concat(" "+s.substring(i+1,j+1));//we can also use + instead of concat
			}
		}
		return r;
	}

	public static String reverseWords(String s) {
		String[] str = s.split(" ");
		Stack<String> stack = new Stack();
		for (int i = 0; i < str.length; i++) {
			if (str[i].isEmpty())
				continue;
			else
				stack.push(str[i]);
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		return sb.toString().trim();
		// SC:O(N-spaces)
		// TC:O(N)
	}
}
