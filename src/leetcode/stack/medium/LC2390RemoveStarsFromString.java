package leetcode.stack.medium;

import java.util.Stack;

public class LC2390RemoveStarsFromString {

    public static void main(String[] args) {

        String s="leet**cod*e";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s) {

        Stack<Character> st = new Stack();
        for(int i=0; i< s.length(); i++){
            char ch=s.charAt(i);
            if(ch!='*')
                st.push(ch);
            else
                st.pop();
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();

        //TC:O(N)
        //SC:O(N)
    }
}
