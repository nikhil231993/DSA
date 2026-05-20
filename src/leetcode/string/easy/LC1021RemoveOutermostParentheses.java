package leetcode.string.easy;

import java.util.Stack;

public class LC1021RemoveOutermostParentheses {

    public static void main(String[] args) {

        String s="(()())(())";
        s="(())";
        System.out.println(removeOuterParentheses(s));
        System.out.println(removeOuterParenthesesOptimized(s));
    }

    private static String removeOuterParentheses(String s){

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
        //SC:O(n) stack
    }

    private static String removeOuterParenthesesOptimized(String s) {
        int count=0;
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(count>0)
                    sb.append(ch);
                count++;
            }else{
                count--;
                if(count>0)
                    sb.append(ch);
            }
        }
        return sb.toString();

        //TC:O(n)
        //SC:O(1)
    }
}
