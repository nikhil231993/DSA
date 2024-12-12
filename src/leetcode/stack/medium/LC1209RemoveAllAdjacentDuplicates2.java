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
		System.out.println(removeDuplicatesSelf(s, k));
	}

	public static String removeDuplicates(String s, int k) {

		Stack<Node> stack = new Stack<>();

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

	public static String removeDuplicatesSelf(String s, int k) {

		Stack<Node> st=new Stack();
		int n=s.length();
		for(int i=0; i<n; i++){
			char c=s.charAt(i);
			if(!st.isEmpty() && st.peek().key==c){
				Node n1=st.pop();
				if(n1.value==k-1)
					continue;
				else{
					Node n2=new Node(c, n1.value+1);
					st.push(n2);
				}
			}else if(st.isEmpty() || st.peek().key!=c){
				st.push(new Node(c, 1));
			}
		}

		String str="";
		while(!st.isEmpty()){
			Node n3=st.pop();
			for(int i=0;i<n3.value;i++){
				str=n3.key + str;
			}
		}
		return str;
	}
}
