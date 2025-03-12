package leetcode.string.easy;

import java.util.Stack;

public class LC1614MaxDepthParenthesis {

    public static void main(String[] args) {

        String s = "(1+(2*3)+((8)/4))+1";

        //Approach 1:
        System.out.println(maxDepth(s));

        //Approach 2:
        System.out.println(maxDepthBetter(s));
    }

    public static int maxDepth(String s) {

        int max=Integer.MIN_VALUE;
        Stack<Character> st=new Stack();

        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }else if(ch==')'){
                if(st.peek()=='('){
                    max=Math.max(max,st.size());
                    st.pop();
                }
            }
        }
        if(max==Integer.MIN_VALUE)
            return 0;
        return max;

        //TC:O(n)
        //SC:O(n)
    }

    public static int maxDepthBetter(String s) {

        int max=Integer.MIN_VALUE;
        int count=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                count++;
            }else if(ch==')'){
                count--;
            }
            max=Math.max(max,count);
        }
        return max==Integer.MIN_VALUE?0:max;

        //TC:O(n)
        //SC:O(1)
    }
}
