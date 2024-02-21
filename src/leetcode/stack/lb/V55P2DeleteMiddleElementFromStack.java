package leetcode.stack.lb;

import java.util.Stack;

public class V55P2DeleteMiddleElementFromStack {

    public static void deleteMiddle(Stack<Integer> inputStack, int N) {

        int[] count=new int[]{0};
        solve(inputStack, N, count);
    }

    public static void solve(Stack<Integer> st, int N, int[] count){

        if(count[0]==(N-1)/2){
            st.pop();
            return;
        }
        int num=st.pop();
        count[0]++;
        solve(st, N, count);
        st.push(num);
    }
}
