package leetcode.stack.medium;

import java.util.HashMap;
import java.util.Stack;

public class LC316RemoveDuplicateLetters {

    public static void main(String[] args) {

        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));

        //Using map
        System.out.println(removeDuplicateLettersUsingMap(s));
    }

    public static String removeDuplicateLetters(String s) {

        Stack<Integer> st=new Stack<>();

        //Store the last index of each character in the arrays of 26
        int[] charArray=new int[26];

        for(int i=0; i<s.length();i++){
            charArray[s.charAt(i)-'a']=i;
        }

        boolean[] visited=new boolean[26];

        for(int i=0; i < s.length(); i++){
            Integer ch=s.charAt(i)-'a';

            if(visited[ch])
                continue;

            visited[ch]=true;

            while(!st.isEmpty() && ch < st.peek() && i < charArray[st.peek()]){
                visited[st.pop()]=false;
            }
            st.push(ch);
        }

        StringBuilder sb=new StringBuilder();
        for(int l: st){
            sb.append((char)(l+'a'));
        }

        return sb.toString();

        //TC:O(n)
        //SC:O(n+n) + last result string
    }

    public static String removeDuplicateLettersUsingMap(String s) {

        int n=s.length();
        HashMap<Character, Integer> map=new HashMap();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i), i);
        }

        Stack<Character> st=new Stack();
        boolean[] visited=new boolean[26];
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(visited[c-'a'])
                continue;
            visited[c-'a']=true;

            while(!st.isEmpty() && st.peek()>s.charAt(i) && map.get(st.peek())>i){
                visited[st.pop()-'a']=false;
            }
            st.push(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for(char s1:st){
            sb.append(s1);
        }
        return sb.toString();
    }
}

