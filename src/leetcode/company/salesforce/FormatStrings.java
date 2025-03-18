package leetcode.company.salesforce;

import java.util.*;


class Node{

    protected char c;
    protected int count;

    public Node(char c, int count){
        this.c=c;
        this.count=count;
    }
}

public class FormatStrings {

    public static void main(String[] args) {

        String s="abccdddeeaaaba";
        System.out.println(func(s));
    }

    public  static String func(String s) {

        Stack<Node> st=new Stack();
        int n=s.length();
        for(int i=0;i<n;i++){

            if(st.isEmpty())
                st.push(new Node(s.charAt(i), 1));
            else if(st.peek().c==s.charAt(i)){
                Node node=st.pop();
                node.count++;
                st.push(node);
            }else{
                st.push(new Node(s.charAt(i), 1));
            }
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            Node node=st.pop();
            if(node.count==1)
                sb.append(node.c);
            else{
                sb.append(node.count);
                sb.append(node.c);
            }
        }
        return sb.reverse().toString();
    }
}
