package leetcode.stack.hw;

import java.util.Stack;

public class V16EvaluatePrefixExpression {

    public static void main(String[] args) {

        String  s="-+7*45+20";
        System.out.println(evaluate(s));
    }

    public static int evaluate(String s){

        int n=s.length();
        Stack<Integer> st=new Stack<>();

        for(int i=n-1; i>=0; i--){

            char ch=s.charAt(i);
            if(ch==' ')
                continue;

            if(ch=='+'){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num1+num2);
            }else if(ch=='-'){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num1-num2);
            }else if(ch=='*'){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num1*num2);
            }else if(ch=='/'){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num1/num2);
            }else st.push(Integer.valueOf(ch-'0'));
        }
        return st.pop();
    }
}
