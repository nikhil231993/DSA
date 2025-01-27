package leetcode.string.medium;

import java.util.Stack;

public class LC151ReverseWordsInAString {

	public static void main(String[] args) {

		String s = "      hello world  ";

		//Approach 1
		System.out.println(reverseWords(s));

		//Approach 2
		System.out.println(reverseWordsInPlace(s));

		//Approach 3: Best
		System.out.println(reverseWordsOptimized(s));
	}

	private static String reverseWordsInPlace(String s) {

		int i = s.length() - 1, j = 0;
		StringBuilder sb = new StringBuilder();

		while(i>=0) {
			while(i>=0 && s.charAt(i)==' ')
				i--;
			j=i;
			while(i>=0 && s.charAt(i)!= ' ')
				i--;
			if(sb.length()==0) {
				sb.append(s.substring(i+1,j+1));
			}else {
				sb.append(" "+s.substring(i+1,j+1));//we can also use + instead of concat
			}
		}
		if(sb.charAt(sb.length()-1)==' ')
			return sb.deleteCharAt(sb.length()-1).toString();
		return sb.toString();
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

		//SC: O(N-spaces)
		//TC: O(N)
	}

	public static String reverseWordsOptimized(String s) {

		int n=s.length();
		int i=n-1;
		StringBuilder sb=new StringBuilder();

		while(i>=0){
			while(i>=0 && s.charAt(i)==' ')
				i--;
			int j=i;
			while(i>=0 && s.charAt(i)!=' ')
				i--;
			if(s.substring(i+1, j+1).length()!=0){
				sb.append(s.substring(i+1, j+1));
				sb.append(" ");
			}
		}
		return sb.deleteCharAt(sb.length()-1).toString();
	}
}
