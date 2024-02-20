package leetcode.queue.striver;


import java.util.LinkedList;
import java.util.Queue;

class MyStackUsingOneQueue {

    Queue<Integer> q1=new LinkedList<>();

    public MyStackUsingOneQueue() {

    }

    public void push(int x) {

        q1.add(x);
        for(int i=0;i<q1.size()-1; i++){
            q1.add(q1.remove());
        }
        //TC:O(N)
        //SC:O(N)
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
}

public class V3StackUsingOneQueue {

    public static void main(String[] args) {

        MyStackUsingOneQueue m=new MyStackUsingOneQueue();
        m.push(1);
        m.push(10);

        System.out.println(m.empty());

        System.out.println(m.pop());

        System.out.println(m.top());
    }
}
