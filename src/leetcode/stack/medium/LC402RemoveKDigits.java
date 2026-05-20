package leetcode.stack.medium;

import java.util.Stack;

public class LC402RemoveKDigits {

    public static void main(String[] args) {

        String num = "54321";
//        String num="1432219";
        num="142999";
        num="12345";
        num="143876";
        int k = 4;
        System.out.println(removeKdigits(num, k));

        //use this as using STringBuilder reduces TC from n square to n due to avoiding of concatenation of string in loop
        System.out.println(removeKdigitsSelf(num, k));
    }

    private static String removeKdigits(String num, int k) {

        int n=num.length();
        Stack<Character> st=new Stack();

        for(int i=0; i< n; i++){

            char ch=num.charAt(i);
            while(!st.isEmpty() && k>0 && ch<st.peek()){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }

        String ans="";
        while(!st.isEmpty()){
            ans=st.pop()+ans;
        }

        int i=0;

        while(ans.length() > i){
            if(ans.charAt(i)=='0')
                i++;
            else
                break;
        }

        return ans.substring(i).length()==0?"0":ans.substring(i);

        //TC:O(n)
        //SC:O(n)
    }

    private static String removeKdigitsSelf(String num, int k) {
        int n=num.length();
        Stack<Integer> st=new Stack();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && k!=0 && st.peek()>(num.charAt(i)-'0')){
                k--;
                st.pop();
            }
            st.push(num.charAt(i)-'0');
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder sb=new StringBuilder();
        for(int no: st)
            sb.append(no);


        int i=0;
        int len=sb.length();
        while(i<len){
            if(sb.charAt(i)=='0')
                i++;
            else break;
        }
        return sb.substring(i).length()==0?"0":sb.substring(i);
    }
}
