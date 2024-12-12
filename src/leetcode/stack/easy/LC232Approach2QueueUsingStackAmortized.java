package leetcode.stack.easy;

import java.util.Stack;

public class LC232Approach2QueueUsingStackAmortized {

    //1. We keep two diff stack to maintain push and pop
    //2. This will be amortized

    Stack<Integer> input=new Stack<>();
    Stack<Integer> output=new Stack<>();

    public LC232Approach2QueueUsingStackAmortized() {

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {

        if(!output.isEmpty())
            return output.pop();
        else{
            while(!input.isEmpty()){
                output.push(input.pop());
            }
            return output.pop();
        }
    }

    public int peek() {

        if(!output.isEmpty())
            return output.peek();
        else{
            while(!input.isEmpty()){
                output.push(input.pop());
            }
            return output.peek();
        }
    }

    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
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
