package leetcode.twopointer.easy;

import java.util.Stack;

public class LC2000ReversePrefixOfWord {

    public static void main(String[] args) {

        String word = "abcdefd";
        char ch = 'd';

        //Approach 1:
        System.out.println(reversePrefix(word,ch));

        //Approach 2:
        System.out.println(reversePrefixApproach(word,ch));
    }

    private static String reversePrefixApproach(String word, char ch) {

        int n=word.length();
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0; i<n; i++){

            char c=word.charAt(i);
            st.push(c);
            if(c == ch){
                while (!st.isEmpty()){
                    sb.append(st.pop());
                }

                i++;  //To move to next element
                while(i<n){
                    sb.append(word.charAt(i++));
                }
                return sb.toString();
            }
        }
        return word;

        // TC:O(n)
        // SC:O(n)
    }

    public static String reversePrefix(String word, char ch) {

        char[] ch1=word.toCharArray();
        int right=0;
        for(int i=0;i<word.length();i++){
            if(ch1[i]==ch){
                right=i;
                break;
            }
        }
        int left=0;
        while(left<=right){
            char temp=ch1[left];
            ch1[left]=ch1[right];
            ch1[right]=temp;
            left++;
            right--;
        }
        return new String(ch1);

        //TC:O(n)
        //SC:O(n)
    }
}
