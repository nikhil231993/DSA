package leetcode.stack.medium;

import java.util.Stack;

public class LC155StackMinWithStack {

    Stack<Integer> st=null;
    Stack<Integer> min=null;

	public LC155StackMinWithStack() {
    st=new Stack<>();
    min=new Stack<>();
	}

	public void push(int val) {
        st.push(val);

        if(min.isEmpty() || min.peek() >val)
            min.push(val);
	}

	public  void pop() {

        if(min.peek() == st.peek())
            min.pop();
        st.pop();
	}

	public  int top() {
        return st.peek();
	}

	public  int getMin() {
        return min.peek();
	}

	public static void main(String[] args) {
        LC155StackMinWithStack lc=new LC155StackMinWithStack();
        lc.push(2);
        lc.push(20);

        lc.push(34);
        lc.push(3);
        lc.push(0);
        lc.push(10);
        lc.push(-1);
        System.out.println(lc.top());
        lc.pop();;
        System.out.println(lc.getMin());
        System.out.println(lc.top());







	}

}
