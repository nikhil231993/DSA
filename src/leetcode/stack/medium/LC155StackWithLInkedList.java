package leetcode.stack.medium;

import java.util.Stack;

class NodeWithMin{
    int val;
    int minVal;
    NodeWithMin next;

    public NodeWithMin(int val,int minVal){
        this.val=val;
        this.minVal=minVal;
    }
}
public class LC155StackWithLInkedList {

    NodeWithMin head=null;
    public LC155StackWithLInkedList() {
    }

    public void push(int val) {

        if(head==null)
        {
            head=new NodeWithMin(val,val);
        }else{
            NodeWithMin node=new NodeWithMin(val,Math.min(val,head.minVal));
            node.next=head;
            head=node;
        }

    }

    public  void pop() {
        if(head!=null)
            head=head.next;
    }

    public  int top() {
       return head.val;

    }

    public  int getMin() {
        return head.minVal;
    }

    public static void main(String[] args) {
        LC155StackWithLInkedList lc=new LC155StackWithLInkedList();
        lc.push(2);
        lc.push(20);

        lc.push(34);
        lc.push(3);
        lc.push(0);
        lc.push(-1);
        lc.push(10);

        System.out.println(lc.top());
        lc.pop();;
        System.out.println(lc.getMin());
        System.out.println(lc.top());
    }
}
