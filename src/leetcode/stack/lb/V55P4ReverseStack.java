package leetcode.stack.lb;

import java.util.Stack;

public class V55P4ReverseStack {

    public static void reverseStack(Stack<Integer> stack) {
        if(stack.isEmpty())
            return;
        int num=stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, num);
    }

    public static void insertAtBottom(Stack<Integer> st, int value){
        if(st.isEmpty()){
            st.push(value);
            return;
        }
        int num=st.pop();
        insertAtBottom(st,value);
        st.push(num);
    }
}
