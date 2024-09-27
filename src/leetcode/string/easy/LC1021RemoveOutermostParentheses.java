package leetcode.string.easy;

import java.util.Stack;

public class LC1021RemoveOutermostParentheses {

    public static void main(String[] args) {

        String s="(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s){

        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){

            char ch=s.charAt(i);
            if(ch=='('){
                if(!st.isEmpty()){
                    sb.append(ch);
                }
                st.push(ch);
            }else {
                st.pop();
                if (!st.isEmpty()) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();

        //TC:O(n)
        //SC:O(n) answer
    }
}
