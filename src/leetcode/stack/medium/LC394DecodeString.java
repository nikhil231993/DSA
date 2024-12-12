package leetcode.stack.medium;

import java.util.Stack;

public class LC394DecodeString {

    public static void main(String[] args) {

        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        int n=s.length();

        Stack<Integer> freqStack=new Stack();
        Stack<StringBuilder> strStack=new Stack();

        int currNo=0;
        StringBuilder str=new StringBuilder();
        for(int i=0; i<n; i++){

            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                currNo=currNo*10+ch-'0';
            }else if(Character.isLetter(ch)){
                str.append(ch);
            }else if(ch=='['){
                freqStack.push(currNo);
                strStack.push(str);
                str=new StringBuilder();
                currNo=0;
            }else if(ch==']'){

                StringBuilder temp=str;
                Integer freq=freqStack.pop();
                str=strStack.pop();
                while(freq>0){
                    str.append(temp);
                    freq--;
                }
            }
        }
        return str.toString();

        //TC:O(n)
        //SC:O(n)
    }
}
