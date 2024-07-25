package leetcode.array.easy;

import java.util.Stack;

public class LC20ValidParenthesis {
	public static void main(String[] args) {

		String s = "(])";
		System.out.println(validParen(s));
	}

	private static boolean validParen(String s) {

		Stack<Character> stack = new Stack();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				stack.push(')');
			else if (s.charAt(i) == '[')
				stack.push(']');
			else if (s.charAt(i) == '{')
				stack.push('}');
			else if (stack.isEmpty() || s.charAt(i)!=stack.pop())
				return false;
		}
		if(!stack.isEmpty())
			return false;
		
		return true;

		//TC:O(n)
		//SC:O(n)
	}
}
