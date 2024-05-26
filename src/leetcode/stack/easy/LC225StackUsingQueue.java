package leetcode.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

public class LC225StackUsingQueue {

        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        public LC225StackUsingQueue() {

        }

        public void push(int x) {
            q2.add(x);
            while(!q1.isEmpty()){
                q2.add(q1.peek());
                q1.remove();
            }
            Queue<Integer> q=q1;
            q1=q2;
            q2=q;
        }

        public int pop() {
            if(!q1.isEmpty()){
                return q1.remove();
            }
            return -1;
        }

        public int top() {
            if(!q1.isEmpty()){
                return q1.peek();
            }
            return -1;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

