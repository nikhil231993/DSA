package leetcode.stack.hellowworld;

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

            char ch = s.charAt(i);
            if(ch==' ')
                continue;
            else if(Character.isDigit(ch)){
                st.push(Integer.parseInt(String.valueOf(ch)));
                continue;
            }

            int num1=st.pop();
            int num2=st.pop();

            if(ch=='+'){
                st.push(num1+num2);
            }else if(ch=='-'){
                st.push(num1-num2);
            }else if(ch=='*'){
                st.push(num1*num2);
            }else if(ch=='/'){
                st.push(num1/num2);
            }
        }
        return st.pop();
    }
}
