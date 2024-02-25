package leetcode.stack.lb;

import java.util.Stack;

public class V55P5SortStack {

    public static void sortStack(Stack<Integer> stack) {

        if(stack.isEmpty())
            return;
        int num=stack.pop();
        sortStack(stack);

        sorting(stack, num);
    }

    public static void sorting(Stack<Integer> st, int num){
        if(st.isEmpty() || (!st.isEmpty() && st.peek() <num )){
            st.push(num);
            return;
        }

        int previousNum=st.pop();
        sorting(st, num);
        st.push(previousNum);
    }
}
