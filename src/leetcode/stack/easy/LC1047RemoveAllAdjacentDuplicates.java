package leetcode.stack.easy;

import java.util.Stack;

public class LC1047RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {

        String s= "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {

        Stack<Character> st=new Stack();

        for(int i=0; i< s.length(); i++){

            Character ch=s.charAt(i);

            if(st.isEmpty() || st.peek()!=ch)
                st.push(ch);
            else if(st.peek()==ch)
                st.pop();
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());

        return sb.reverse().toString();
    }
}
