package leetcode.stack.hard;

import java.util.Stack;

public class LC32LongestValidParenthesis {

    public static void main(String[] args) {

        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        if(s==null || s.length()<2)
            return 0;

        Stack<Integer> st=new Stack();
        int n=s.length();

        for(int i=0; i<n;i++){

            char ch=s.charAt(i);
            if(ch=='(')
                st.push(i);
            else{
                if(!st.isEmpty() && s.charAt(st.peek())=='(')
                    st.pop();
                else
                    st.push(i);
            }
        }

        int maxLen=Integer.MIN_VALUE;
        int termIndex=n;

        while(!st.isEmpty()){
            maxLen=Math.max(maxLen, termIndex-st.peek()-1);
            termIndex=st.pop();
        }
        return Math.max(termIndex, maxLen);
    }
}
