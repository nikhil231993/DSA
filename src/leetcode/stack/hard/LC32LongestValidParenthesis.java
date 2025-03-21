package leetcode.stack.hard;

import java.util.Stack;

public class LC32LongestValidParenthesis {

    public static void main(String[] args) {

        String s = ")()())";
        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParenthesesAlternativeStackCondition(s));
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
            maxLen = Math.max(maxLen, termIndex-st.peek()-1);
            termIndex = st.pop();
        }
        return Math.max(termIndex, maxLen);

        //TC:O(N) + O(k) stack size
        //SC:O(N)
    }

    public static  int longestValidParenthesesAlternativeStackCondition(String s) {

        Stack<Integer> st=new Stack();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(')
                st.push(i);
            else{
                if(st.isEmpty() || s.charAt(st.peek())!='(')
                    st.push(i);
                else
                    st.pop();
            }
        }

        int max=0;
        int last=n;
        while(!st.isEmpty()){
            max=Math.max(max, last-st.peek()-1);
            last=st.pop();
        }
        max=Math.max(last, max);
        return max;
    }
}
