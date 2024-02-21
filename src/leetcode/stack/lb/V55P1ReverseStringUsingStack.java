package leetcode.stack.lb;

import java.util.Stack;

public class V55P1ReverseStringUsingStack {

    public static void main(String[] args) {

        String s ="Nikhil";
        System.out.println(reverseString(s));
    }

    public static String reverseString(String str) {
        // Write your code here.

        Stack<Character> st=new Stack();

        for(int i=0; i< str.length(); i++){
            st.push(str.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
        //TC:O(2N)
        //SC:O(N)
    }
}
