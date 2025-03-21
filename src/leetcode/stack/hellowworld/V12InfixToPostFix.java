package leetcode.stack.hellowworld;

import java.util.Stack;

public class V12InfixToPostFix {

    public static void main(String[] args) {

        String s="h^m^q^(7-4)";
        s="a^b*c";
        s="a^b^c*d";
        //s="a^b^c";
        //s="(a+b)*c";
        //s="a*b*c";
        System.out.println(infixToPostfix(s));
    }

    public static String infixToPostfix(String exp) {

        //step 1 : Print all operands or ad it to the result
        //step 2: if stack empty add operator into stack
        //step 3: if ch==( push it into stack
        //step 4: if ch==). pop out elements till )
        //step 5: if ch > st.peek() push into stack and if ch < st.peek() pop out
        //step 6: if ch==st.peek() and precedence L of ch, pop out and  if precedence R push into stack

        int n=exp.length();

        Stack<Character> st=new Stack();
        StringBuilder result=new StringBuilder();

        for(int i=0; i< n;i++){

            Character ch=exp.charAt(i);

            if(ch==' ')
                continue;

            if(Character.isLetter(ch) || Character.isDigit(ch)){
                result.append(ch);
            }else if(ch=='(')
                st.push(ch);
            else if(ch==')'){

                while(!st.isEmpty() && st.peek()!='('){
                    result.append(st.pop());
                }
                st.pop();
            }else{

                while(!st.isEmpty() && (prec(st.peek()) >= prec(ch) && associativity(ch) == 'L')){
                    result.append(st.pop());
                }
                st.push(ch);
            }
        }

        while(!st.isEmpty()){
            result.append(st.pop());
        }
        return result.toString();

        //TC:O(n)
        //SC:O(n)
    }

    public static int prec(char ch){

        if(ch=='^')
            return 3;
        else if(ch=='+' || ch=='-')
            return 1;
        else if(ch=='*' || ch=='/')
            return 2;
        return -1;
    }

    public static char associativity(char ch){
        if(ch=='^')
            return 'R';
        return 'L';
    }
}
