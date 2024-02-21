package leetcode.stack.lb;

import java.util.Stack;

public class V55P3InsertElementAtBootomOfStack {

    public static Stack<Integer> pushAtBottom(Stack <Integer> myStack, int x)
    {
        solve(myStack, x);
        return myStack;
    }

    public static void solve(Stack<Integer> st, int value){
        if(st.isEmpty()){
            st.push(value);
            return;
        }
        int num=st.pop();
        solve(st,value);
        st.push(num);
    }
}
