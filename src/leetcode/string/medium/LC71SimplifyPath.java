package leetcode.string.medium;

import java.util.Stack;

public class LC71SimplifyPath {

	public static void main(String[] args) {
		String path = "/home//foo/";
		System.out.println(simplifyPath(path));
	}

	private static String simplifyPath(String path) {
	Stack<String> st=new Stack();
	
	for(int i=0;i<path.length();i++) {
			if(path.charAt(i)=='/')
				continue;
			String temp="";
			while (i < path.length() && path.charAt(i) != '/') {
			temp+=path.charAt(i);
			i++;
		}
			if (temp.equals("."))
				continue;
			else if (temp.equals("..")) {
				if (!st.isEmpty())
					st.pop();
			} else {
				st.push(temp);
			}
		}
		String res = "";
		while (!st.isEmpty()) {
			res = "/" + st.pop() + res;
		}
	
		if (res.isEmpty())
			res = "/";
		return res;

		//TC:O(n)
		//SC:O(n)
	}
}
