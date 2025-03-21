package leetcode.stack.hellowworld;

import java.util.Stack;

public class V15InfixToPrefix {

    public static void main(String[] args) {

        String s="x+y/z-w*u";
        s="a^b*c-d";
        s="a*b^c";
        //s="a*b-c";
        //s="a+b*c";
        System.out.println(conversion(s));
    }

    private static String conversion(String s) {

        Stack<Character> st=new Stack<>();

        StringBuilder result=new StringBuilder();
        int n=s.length();

        for(int i=n-1; i>=0; i--){
            char ch=s.charAt(i);

            if(ch==' ')
                continue;

            if(Character.isDigit(ch) || Character.isLetter(ch))
                result.append(ch);
            else if(ch==')')
                st.push(ch);
            else if(ch=='('){

                while(!st.isEmpty() && st.peek()!=')'){
                    result.append(st.pop());
                }
                st.pop();
            }else{

                if(!st.isEmpty() && V12InfixToPostFix.prec(ch) == V12InfixToPostFix.prec(st.peek()) &&
                        V12InfixToPostFix.associativity(ch)=='L') {
                    st.push(ch);
                    continue;
                }
                while(!st.isEmpty() && V12InfixToPostFix.prec(ch) < V12InfixToPostFix.prec(st.peek()) &&
                        V12InfixToPostFix.associativity(ch)=='L') {
                    result.append(st.pop());
                }

                if(!st.isEmpty() && V12InfixToPostFix.prec(ch)== V12InfixToPostFix.prec(st.peek()) &&
                        V12InfixToPostFix.associativity(ch)=='R'){
                    result.append(st.pop());
                }

                st.push(ch);
            }
        }

        while(!st.isEmpty())
            result.append(st.pop());

        return result.reverse().toString();

        //TC:O(n)
        //SC:O(n)
    }
}
