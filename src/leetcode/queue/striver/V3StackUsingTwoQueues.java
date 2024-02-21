package leetcode.queue.striver;


import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();
    public MyStack() {

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

        //TC:O(N)
        //SC:O(2n) for two queues + O(n) for extra queue which is used in swapping
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
public class V3StackUsingTwoQueues {

    public static void main(String[] args) {

        MyStack m=new MyStack();
        m.push(1);
        m.push(10);

        System.out.println(m.empty());

        System.out.println(m.pop());

        System.out.println(m.top());
    }
}
