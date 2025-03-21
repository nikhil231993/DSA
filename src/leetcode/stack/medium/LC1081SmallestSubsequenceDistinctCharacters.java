package leetcode.stack.medium;

import java.util.Stack;

public class LC1081SmallestSubsequenceDistinctCharacters {

    public static void main(String[] args) {

        String s = "bcabc";
        System.out.println(smallestSubsequence(s));
    }

    public static String smallestSubsequence(String s) {

        int n=s.length();
        Stack<Integer> st=new Stack();

        int[] arr=new int[26];
        boolean[] visited=new boolean[26];

        for(int i=0; i< n; i++){
            arr[s.charAt(i)-'a']=i;
        }

        for(int i=0; i< n; i++){
            Integer ch=s.charAt(i)-'a';

            if(visited[ch])
                continue;

            visited[ch]=true;
            while(!st.isEmpty() && ch < st.peek() && i < arr[st.peek()]){
                visited[st.pop()]=false;
            }
            st.push(ch);
        }

        StringBuilder sb=new StringBuilder();
        for(int l: st){
            sb.append((char)(l+'a'));
        }
        return sb.toString();

        // TC:O(n)
        // SC:O(n+n) + last result string
    }
}
