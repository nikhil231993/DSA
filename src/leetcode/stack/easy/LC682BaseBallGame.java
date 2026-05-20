package leetcode.stack.easy;

import java.util.Stack;

public class LC682BaseBallGame {

    public static void main(String[] args) {

        String[] ops =new String[] {"5","2","C","D","+"};
        System.out.println(calPoints(ops));
        System.out.println(calPointsSelf(ops));
    }

    private static int calPoints(String[] operations) {

        Stack<String> st=new Stack();

        for(int i=0; i<operations.length; i++){
            String s=operations[i];
            if(!s.equals("C") && !s.equals("D") && !s.equals("+"))
                st.push(s);
            else if(s.equals("C"))
                st.pop();
            else if(s.equals("D")){
                Integer n=Integer.parseInt(st.peek());
                Integer result=n*2;
                st.push(String.valueOf(result));
            }else{
                Integer n1=Integer.parseInt(st.pop());
                Integer n2=Integer.parseInt(st.pop());
                Integer result=n1+n2;
                st.push(String.valueOf(n2));
                st.push(String.valueOf(n1));
                st.push(String.valueOf(result));
            }
        }

        int sum=0;
        while(!st.isEmpty()){
            sum += Integer.parseInt(st.pop());
        }
        return sum;

        //TC:O(n)
        //SC:O(n)
    }

    private static int calPointsSelf(String[] operations) {
        int n=operations.length;
        Stack<Integer> st=new Stack();
        for(int i=0;i<n;i++){
            String op=operations[i];
            if(op.equals("+")){
                int num1=st.pop();
                int num2=st.pop();
                st.push(num2);
                st.push(num1);
                st.push(num1+num2);
            }else if(op.equals("C"))
                st.pop();
            else if(op.equals("D")){
                int num=st.peek();
                st.push(2*num);
            }else{
                st.push(Integer.parseInt(op));
            }
        }
        int sum=0;
        while(!st.isEmpty())
            sum+=st.pop();

        return sum;
    }
}
