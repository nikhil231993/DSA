package leetcode.stack.lb;

import java.util.Stack;

public class V55P6RedundantBrackets {

    public static void main(String[] args) {

        String s="(a+c*b)+(c))";
        System.out.println(findRedundantBrackets(s));
    }

    public static boolean findRedundantBrackets(String s) {

        Stack<Character> st=new Stack();

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);

            if(ch=='(' || ch=='+' || ch=='-' || ch=='*' || ch=='/')
                st.push(ch);
            else{
                if(ch == ')'){
                    boolean redundant=true;
                    while(st.peek() != '('){
                        char top=st.peek();
                        if(top=='+' || top=='-' || top=='*' || top=='/'){
                            redundant=false;
                        }
                        st.pop();
                    }

                    if(redundant==true)
                        return true;
                    st.pop();
                }
            }
        }
        return false;

        //TC:O(2*N)
        //SC:O(N)
    }
}
