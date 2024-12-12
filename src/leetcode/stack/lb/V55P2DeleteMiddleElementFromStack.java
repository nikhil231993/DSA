package leetcode.stack.lb;

import java.util.Stack;

public class V55P2DeleteMiddleElementFromStack {

   // https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1

    public static void main(String[] args) {

        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);

        deleteMiddle( st, st.size());

        System.out.println("==================");

        while(!st.isEmpty())
            System.out.println(st.pop());
    }

    public static void deleteMiddle(Stack<Integer> inputStack, int N) {

        int[] count=new int[]{0};
        solve(inputStack, N, count);
    }

    public static void solve(Stack<Integer> st, int N, int[] count){

        if(count[0] == N/2){ // N/2 is used as we calculate from top
            st.pop();
            return;
        }
        int num=st.pop();
        count[0]++;
        solve(st, N, count);
        st.push(num);
    }
}
