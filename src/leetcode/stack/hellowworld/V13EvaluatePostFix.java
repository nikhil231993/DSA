package leetcode.stack.hellowworld;

import java.util.Stack;

public class V13EvaluatePostFix {

    public static void main(String[] args) {

        String s = "231*+9-";
        System.out.println(evaluatePostFix(s));
    }

    public static int evaluatePostFix(String s) {

        int n=s.length();
        Stack<Integer> st=new Stack();

        for(int i=0; i<n; i++){

            char ch=s.charAt(i);

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
            }else if(ch=='-')
                st.push(num2-num1);
            else if(ch=='*')
                st.push(num1*num2);
            else if(ch=='/')
                st.push(num2/num1);
        }
        return st.peek();

        // TC:O(n)
        // SC:O(n)
    }
}
