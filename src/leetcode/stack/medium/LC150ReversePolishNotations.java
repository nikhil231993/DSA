package leetcode.stack.medium;

import java.util.*;

public class LC150ReversePolishNotations {

    public static void main(String[] args) {

        String[] tokens =new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> st=new Stack();

        int n=tokens.length;

        for(int i=0; i<n; i++){

            if(tokens[i].equals("+")){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num2+num1);
            }else if(tokens[i].equals("-")){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num2-num1);
            }else if(tokens[i].equals("*")){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num2*num1);
            }else if(tokens[i].equals("/")){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num2/num1);
            }else{
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.pop();

        //TC:O(n)
        //SC:O(n)
    }
}
