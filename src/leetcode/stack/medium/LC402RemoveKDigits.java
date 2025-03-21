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
    }

    public static String removeKdigits(String num, int k) {

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
}
