package leetcode.stack.easy;

import java.util.Stack;

public class LC844BackSpaceStringComparison {

	public static void main(String[] args) {

		String s = "ab#c";
		String t = "ad#c";

		//Approach 1: Using Extra space
		System.out.println(backspaceCompare(s, t));

		//Approach 2: Without using extra space which is the follow up question
		String firstString=backspaceCompareWithoutStack(s);
		String secondString=backspaceCompareWithoutStack(t);

		//TC:O(s+t)
		//SC:O(1)
		System.out.println(firstString.equals(secondString));
	}

	private static String backspaceCompareWithoutStack(String s) {

		int n=s.length();
		int count=0;

		StringBuilder sb=new StringBuilder();
		for(int i=n-1; i>=0; i--){

			char ch=s.charAt(i);
			if(ch=='#'){
				count++;
			}else{
				if(count>0){
					count--;
				}else{
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}

	public static boolean backspaceCompare(String s, String t) {

		Stack<Character> s1 = new Stack();
		Stack<Character> s2 = new Stack();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '#') {
				s1.push(s.charAt(i));
			} else if (!s1.isEmpty()) {
				s1.pop();
			}
		}

		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) != '#') {
				s2.push(t.charAt(i));
			} else if (!s2.isEmpty()) {
				s2.pop();
			}
		}

		StringBuilder sb1 = new StringBuilder();
		while (!s1.isEmpty()) {
			sb1.append(s1.pop());
		}

		StringBuilder sb2 = new StringBuilder();
		while (!s2.isEmpty()) {
			sb2.append(s2.pop());
		}

		return sb1.reverse().toString().equals(sb2.reverse().toString());

		// TC:O(s+t) s and t are lengths of each string
		// TC:O(s+t) s and t are lengths of each string
	}
}
