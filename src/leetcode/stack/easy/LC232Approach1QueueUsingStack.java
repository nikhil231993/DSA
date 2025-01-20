package leetcode.stack.easy;

import java.util.Stack;

public class LC232Approach1QueueUsingStack {

        //1. Here we push one element into the input stack if the input stack is empty
        //2. If input stack is not empty then we pop all the elements till we have input stack as empty
        //3. Then push one element into stack
        //4. Put back all the elements back into input stack again
        //5. Here push operation is costly. Use it when less push operations

        Stack<Integer> input=new Stack<>();
        Stack<Integer> output=new Stack<>();

        public LC232Approach1QueueUsingStack() {
        }

        public void push(int x) {

            if(empty()){
                input.push(x);
            }else{

                while(!input.isEmpty()){
                    output.push(input.pop());
                }
                input.push(x);  // This can also be pushed to output stack
                while(!output.isEmpty()){
                    input.push(output.pop());
                }
            }
        }

        public int pop() {
            return input.pop();
        }

        public int peek() {
            return input.peek();
        }

        public boolean empty() {
            return input.isEmpty();
        }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
