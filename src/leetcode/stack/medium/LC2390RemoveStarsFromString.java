package leetcode.stack.medium;

import java.util.Stack;

public class LC2390RemoveStarsFromString {

    public static void main(String[] args) {

        String s="leet**cod*e";

        //Approach 1:
        System.out.println(removeStars(s));

        //Approach 2:
        System.out.println(removeStarsUsingSB(s));

        //Approach 3:
        System.out.println(removeStarsUsingTwoPointer(s));
    }

    public static String removeStarsUsingTwoPointer(String s) {

        char[] ch = new char[s.length()];
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                j--;
            } else {
                ch[j++] = c;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < j; i++) {
            answer.append(ch[i]);
        }

        return answer.toString();
    }

    public static String removeStarsUsingSB(String s) {

        int j = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                answer.deleteCharAt(answer.length() - 1);
            } else {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
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
