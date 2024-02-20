package leetcode.stack.lb;

import java.util.Stack;

public class V56P7MinimumCostToMakeStringValid {

    public static void main(String[] args) {

        String s= "{{{}";
        System.out.println(findMinimumCost(s));
    }

    public static int findMinimumCost(String str) {

        if(str.length()%2==1)
            return -1;

        Stack<Character> st=new Stack();

        for(int i=0; i< str.length(); i++){
            char ch= str.charAt(i);

            if(ch=='{'){
                st.push(ch);
            }else{
                if(ch=='}'){
                    if(!st.isEmpty() && st.peek() == '{')
                        st.pop();
                    else
                        st.push(ch);
                }
            }
        }

        int a=0, b=0;
        while(!st.isEmpty()){
            if(st.pop()=='{')
                a++;
            else
                b++;
        }

        return ((a+1)/2 + (b+1)/2);
    }
}
