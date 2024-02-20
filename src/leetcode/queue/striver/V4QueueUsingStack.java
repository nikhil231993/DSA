package leetcode.queue.striver;

import java.util.Stack;

class MyQueue {

    Stack<Integer> s1=new Stack();
    Stack<Integer> s2=new Stack();

    public MyQueue() {

    }

    public void push(int x) {
        if(s1.isEmpty()){
            s1.push(x);
            return;
        }

        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.push(x);

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int pop() {
        if(s1.isEmpty())
            return -1;
        return s1.pop();
    }

    public int peek() {
        if(s1.isEmpty())
            return -1;
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

public class V4QueueUsingStack {

    public static void main(String[] args) {

        MyQueue m= new MyQueue();
        m.push(1);
        m.push(2);

        System.out.println( m.pop());
    }
}
