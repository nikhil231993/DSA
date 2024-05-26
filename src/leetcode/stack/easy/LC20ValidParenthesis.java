package leetcode.stack.easy;

import java.util.Stack;

public class LC20ValidParenthesis {

    public static void main(String[] args) {

        String s = "()[]{}";
        // s = "(]"
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        Stack<Character> st =new Stack();

        for(int i=0; i< s.length(); i++){
            if(s.charAt(i)=='(')
                st.push(')');
            else if(s.charAt(i)=='[')
                st.push(']');
            else if(s.charAt(i)=='{')
                st.push('}');
            else{
                if(st.size()==0)
                    return false;

                if(st.pop()!=s.charAt(i))
                    return false;
            }
        }

        if(st.size()==0)
            return true;
        return false;

        //TC:O(n)
        //SC:O(n)
    }
}
