package leetcode.stack.hw;

import java.util.Stack;

public class V13InfixToPostFix {

    public static void main(String[] args) {

        String s="a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(s));
    }

    public static String infixToPostfix(String exp) {

        int n=exp.length();

        Stack<Character> st=new Stack();
        StringBuilder result=new StringBuilder();

        for(int i=0; i< n;i++){

            Character ch=exp.charAt(i);

            if(ch==' ')
                continue;

            if(Character.isLetter(ch) || Character.isDigit(ch)){
                result.append(ch);
            }else if(ch=='(')
                st.push(ch);
            else if(ch==')'){

                while(!st.isEmpty() && st.peek()!='('){
                    result.append(st.pop());
                }
                st.pop();
            }else{

                while(!st.isEmpty() && (prec(st.peek())>=prec(ch) && associativity(ch)=='L')){
                    result.append(st.pop());
                }
                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            result.append(st.pop());
        }
        return result.toString();
    }

    public static int prec(char ch){
        if(ch=='^')
            return 3;
        else if(ch=='+' || ch=='-')
            return 1;
        else if(ch=='*' || ch=='/')
            return 2;
        return -1;
    }

    public static char associativity(char ch){
        if(ch=='^')
            return 'R';
        return 'L';
    }
}
