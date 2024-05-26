package leetcode.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

public class LC225StackUsingOneQueue {

        Queue<Integer> q1=new LinkedList<>();

        public LC225StackUsingOneQueue() {

        }

        public void push(int x) {

            q1.add(x);
            for(int i=0;i<q1.size()-1; i++){
                q1.add(q1.remove());
            }
        }

        public int pop() {
            if(q1.isEmpty())
                return -1;
            return q1.remove();
        }

        public int top() {
            if(q1.isEmpty())
                return -1;
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
