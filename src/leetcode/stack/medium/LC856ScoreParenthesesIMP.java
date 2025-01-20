package leetcode.stack.medium;

import java.util.Stack;

public class LC856ScoreParenthesesIMP {

    public static void main(String[] args) {

        String s = "(()(()()))";
        s="(())";
        s="(()())";
        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String s) {

        Stack<String> st=new Stack();
        int n=s.length();

        for(int i=0; i< n; i++){
            char ch=s.charAt(i);

            if(ch=='('){
                st.push(ch+"");
            }else{

                Integer indexScore=0;
                while(!st.isEmpty() && !st.peek().equals("(")){
                    indexScore+=Integer.parseInt(st.pop());
                }
                st.pop();
                if(indexScore==0)
                    st.push("1");
                else{
                    st.push(2*indexScore+"");
                }
            }
        }

        int sum=0;
        while(!st.isEmpty()){
            sum+=Integer.parseInt(st.pop());
        }
        return sum;

        //TC:O(n)
        //SC:O(n)
    }
}
