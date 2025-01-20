package leetcode.stack.easy;

import java.util.Stack;

public class LC2696MinimumString {

    public static void main(String[] args) {

        String s = "ABFCACDB";
        System.out.println(minLength(s));
    }

    public static int minLength(String s) {

        Stack<Character> st=new Stack();

        int n=s.length();

        for(int i=0; i< n; i++){
            char ch=s.charAt(i);

            if(st.isEmpty() ||(ch!='B' && ch!='D'))
                st.push(ch);

            else if(ch=='B' || ch=='D'){

                 if((ch=='B' && st.peek()=='A') || (ch=='D' && st.peek()=='C'))
                    st.pop();
                else
                    st.push(ch);
            }
        }
        return st.size();

        // TC:O(n)
        // SC:O(n)
    }
}
