package leetcode.stack.medium;

import java.util.Stack;

class Node {

	char key;
	int value;

	public Node() {

	}

	public Node(char key, int value) {
		this.key = key;
		this.value = value;
	}
}

public class LC1209RemoveAllAdjacentDuplicates2 {

	public static void main(String[] args) {

		String s = "abcd";
		int k = 2;
		System.out.println(removeDuplicates(s, k));
	}

	public static String removeDuplicates(String s, int k) {

		Stack<Node> stack = new Stack<Node>();

		for (int i = 0; i < s.length(); i++) {

			Character ch=s.charAt(i);
			if (stack.isEmpty() || ch != stack.peek().key) {
				stack.push(new Node(ch, 1));
			} else {
				int val = stack.peek().value;
				stack.pop();
				stack.push(new Node(ch, val + 1));
			}
			if (stack.peek().value == k)
				stack.pop();
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			char r = stack.peek().key;
			Integer val = stack.peek().value;
			stack.pop();

			for (int i = 0; i < val; i++) {
				sb.append(r);
			}
		}
		return sb.reverse().toString();

		//TC:O(n)
		//SC:O(n)
	}
}
