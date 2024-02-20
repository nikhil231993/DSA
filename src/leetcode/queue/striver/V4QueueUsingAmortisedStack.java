package leetcode.queue.striver;


import java.util.Stack;

class MyQueueAmortised {

    Stack<Integer> input=new Stack();
    Stack<Integer> output=new Stack();


    public MyQueueAmortised() {

    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if(!output.isEmpty())
            return output.pop();
        else{
            while(!input.isEmpty())
                output.push(input.pop());

            return output.pop();
        }
    }

    public int peek() {
        if(!output.isEmpty())
            return output.peek();
        else{
            while(!input.isEmpty())
                output.push(input.pop());
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
public class V4QueueUsingAmortisedStack {

    public static void main(String[] args) {

        MyQueueAmortised m= new MyQueueAmortised();
        m.push(1);
        m.push(2);

        System.out.println( m.pop());
    }
}
