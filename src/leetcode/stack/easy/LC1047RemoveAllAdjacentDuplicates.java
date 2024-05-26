package leetcode.stack.easy;

import java.util.Stack;

public class LC1047RemoveAllAdjacentDuplicates {

    public static void main(String[] args) {

        String s= "abbaca";

        //Approach 1:
        System.out.println(removeDuplicates(s));

        //Approach 2:
        System.out.println(removeDuplicatesApproach2(s));

        //Approach 3:
        System.out.println(removeDuplicatessb(s));

        //Approach 4:
        System.out.println(removeDuplicatesApproach4(s));
    }

    private static String removeDuplicatessb(String s) {

        int n=s.length();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            if(sb.length() >0 && sb.charAt(sb.length()-1)==s.charAt(i)){
                sb.deleteCharAt(sb.length()-1);
            }else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    private static String removeDuplicatesApproach2(String s) {

        int i=0 ,j=1, n=s.length();
        while(j<s.length()){
            if(i==-1)
                i=0;
            if(i!=j && s.charAt(i)==s.charAt(j)){
                s=s.substring(0,i)+s.substring(j+1,s.length());
                i--;
                j--;
            }else if(s.charAt(i)!=s.charAt(j)) {
                i++;
                j++;
            }else j++;
        }
        return s;
    }

    public static String removeDuplicates(String s) {

        Stack<Character> st=new Stack();

        for(int i=0; i< s.length(); i++){

            Character ch=s.charAt(i);

            if(st.isEmpty() || st.peek()!=ch)
                st.push(ch);
            else if(st.peek()==ch)
                st.pop();
        }

//        StringBuilder sb=new StringBuilder();
//        while(!st.isEmpty())
//            sb.append(st.pop());

        String ans="";
        while(!st.isEmpty())
            ans=st.pop()+ans;

//        return sb.reverse().toString();
        return ans;
    }

    public static String removeDuplicatesApproach4(String S) {

        if(S == null || S.length() == 0) {
            return S;
        }
        int j = 0;
        int n = S.length();
        char[] ans = new char[n];

        for(int i = 0; i < n; i++) {
            ans[j] = S.charAt(i);
            if(j > 0 && ans[j] == ans[j - 1]) {
                j--;
            } else {
                j++;
            }
        }
        return new String(ans, 0, j);
    }
}
