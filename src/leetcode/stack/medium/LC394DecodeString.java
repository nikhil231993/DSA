package leetcode.stack.medium;

import java.util.Stack;

public class LC394DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
        System.out.println(decodeStringSelf(s));
    }

    private static String decodeString(String s) {
        int n=s.length();

        Stack<Integer> freqStack=new Stack<>();
        Stack<StringBuilder> strStack=new Stack<>();

        int currNumber=0;
        StringBuilder currentString=new StringBuilder();
        for(int i=0; i<n; i++){

            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                currNumber=currNumber*10+ch-'0';
            }else if(Character.isLetter(ch)){
                currentString.append(ch);
            }else if(ch=='['){
                freqStack.push(currNumber);
                strStack.push(currentString);
                currentString=new StringBuilder();
                currNumber=0;
            }else if(ch==']'){

                StringBuilder temp=currentString;
                Integer freq=freqStack.pop();
                currentString=strStack.pop();
                while(freq>0){
                    currentString.append(temp);
                    freq--;
                }
            }
        }
        return currentString.toString();

        //TC:O(n)
        //SC:O(n)
    }

    private static String decodeStringSelf(String s) {
        int n=s.length();
        Stack<Integer> num=new Stack();
        Stack<String> s1=new Stack();
        int no=0;
        String str="";
        for(int i=0;i<n;i++){
            if(Character.isDigit(s.charAt(i))){
                no=no*10+(s.charAt(i)-'0');
            }else if(s.charAt(i)=='['){
                num.push(no);
                s1.push(str);
                no=0;
                str="";
            }else if(Character.isLetter(s.charAt(i))){
                str+=s.charAt(i);
            }else if(s.charAt(i)==']'){
                String temp=str;
                StringBuilder sb=new StringBuilder();
                int val=num.pop();
                for(int j=0;j<val;j++)
                    sb.append(temp);
                str=s1.pop()+sb.toString();
            }
        }
        return str.toString();
    }
}
