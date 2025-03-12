package leetcode.string.medium;

import java.util.Stack;

public class LC921MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {

        String s = "(((";
        
        //Approach 1: Brute
        System.out.println(brute(s));
        
        //Approach 2: Brute
        System.out.println(optimal(s));
    }

    private static int optimal(String s) {

        int openBrackets = 0;
        int minAddsRequired = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openBrackets++;
            } else {
                // If an open bracket exists, match it with the closing one
                // If not, we need to add an open bracket.
                if (openBrackets > 0) {
                    openBrackets--;
                } else {
                    minAddsRequired++;
                }
            }
        }

        // Add the remaining open brackets as closing brackets would be required.
        return minAddsRequired + openBrackets;
    }

    public static int brute(String s){

        int n=s.length();

        Stack<Character> st=new Stack();
        for(int i=0;i<n; i++){
            char ch =s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }else{
                if(!st.isEmpty() && st.peek()=='(')
                    st.pop();
                else
                    st.push(ch);
            }
        }
        return st.size();
    }
}
