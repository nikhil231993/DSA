package leetcode.twopointer.easy;

import java.util.Stack;

public class LC917ReverseLetters {

    public static void main(String[] args) {

        String s = "ab-cd";

        //Approach 1:
        System.out.println(reverseOnlyLetters(s));

        //Approach 2:
        System.out.println(reverseOnlyLettersApproachTwo(s));
    }

    private static String reverseOnlyLettersApproachTwo(String s) {

        Stack<Character> st=new Stack<>();
        int n=s.length();

        for(int i=0; i<n ;i++){
            if(Character.isLetter(s.charAt(i))){
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0; i<n; i++){
            if(Character.isLetter(s.charAt(i))){
                sb.append(st.pop());
            }else
                sb.append(s.charAt(i));
        }

        return sb.toString();

        //TC:O(N+N)
        //SC:O(N+N)( Stack and string builder)
    }

    public static String reverseOnlyLetters(String s) {

        String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int left=0;
        int right=s.length()-1;
        char[] ch=s.toCharArray();

        while(left<right){
            while(left<right && letters.indexOf(ch[right])==-1){
                right--;
            }
            while(left<right && letters.indexOf(ch[left])==-1){
                left++;
            }
            char temp=ch[left];
            ch[left]=ch[right];
            ch[right]=temp;
            left++;
            right--;
        }
        return new String(ch);

        //TC:O(n)
        //SC:O(n) We can mention N only if we account it to be used in space of thr answer
    }
}
