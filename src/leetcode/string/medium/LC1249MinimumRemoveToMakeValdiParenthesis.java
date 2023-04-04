package leetcode.string.medium;

import java.util.Stack;

public class LC1249MinimumRemoveToMakeValdiParenthesis {

	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		System.out.println(minimumRemoveUsingStack(s));
		System.out.println(minimumRemoveWithouUsingStack(s));

	}

	private static String minimumRemoveWithouUsingStack(String s) {
		char[] ch = s.toCharArray();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (ch[i] == '(') {
				count++;
			} else if (ch[i] == ')') {
				if (count == 0) {
					ch[i] = '#';
				} else {
					count--;
				}
			}
		}

		count = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (ch[i] == ')') {
				count++;
			} else if (ch[i] == '(') {
				if (count == 0) {
					ch[i] = '#';
				} else {
					count--;
				}
			}
		}
		String str = "";
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != '#') {
				str += ch[i];
			}
		}

		return str;
	}

	private static String minimumRemoveUsingStack(String s) {

		Stack<Integer> stack = new Stack<>();
		char[] c=s.toCharArray();
		
		for (int i = 0; i < s.length(); i++) {
			if (c[i] == '(') {
				stack.push(i);
			} else if (c[i] == ')') {
				if (stack.isEmpty()) {
					c[i] = '#';
				} else {
					stack.pop();
				}
			}
		}

		while (!stack.isEmpty()) {
			int i = stack.pop();
			c[i] = '#';
		}

		String str = "";
		for (int i = 0; i < c.length; i++) {
			if (c[i] != '#') {
				str += c[i];
			}
		}

		return str;
		//TC:O(N)
				//SC:O(N)
	}

}
