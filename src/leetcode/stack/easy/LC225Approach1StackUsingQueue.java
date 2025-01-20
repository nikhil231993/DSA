package leetcode.stack.easy;

import java.util.Queue;
import java.util.LinkedList;

public class LC225Approach1StackUsingQueue {

    //Making POP expensive
    //Step 1: add elements in push in input Queue
    //Step 2: Remove elements from input array keeping one element
    //Step 3: Last element is the ans for pop and peek
    //Step 4: Put back all the elements into input queue

        Queue<Integer> input=new LinkedList();
        Queue<Integer> output=new LinkedList();

        public LC225Approach1StackUsingQueue() {
        }

        public void push(int x) {
            input.offer(x);
        }

        public int pop() {
            int value=-1;
            if(input.isEmpty())
                return value;
            else{
                while(input.size()>1){
                    output.offer(input.poll());
                }
                value=input.poll();
                while(!output.isEmpty()){
                    input.offer(output.poll());
                }
            }
            return value;
        }

        public int top() {

            int value=-1;

            if(input.isEmpty())
                return value;
            else{
                while(input.size()>1){
                    output.offer(input.poll());
                }
                value=input.peek();
                output.offer(input.poll());
                while(!output.isEmpty()){
                    input.offer(output.poll());
                }
            }
            return value;
        }

        public boolean empty() {
            return input.isEmpty();
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
