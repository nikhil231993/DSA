package leetcode.stack.lb;

public class V54TwoStack {

    private int[] arr=null;
    private int top1;
    private int top2;
    private int size;

    // Initialize TwoStack.
    public V54TwoStack(int s) {

        this.top1= -1;
        this.top2= s;
        this.size= s;
        this.arr= new int[s];
    }

    // Push in stack 1.
    public void push1(int num) {

        if(top2-top1 > 1){
            arr[++top1]=num;
        }
        //TC:O(n)
    }

    // Push in stack 2.
    public void push2(int num) {

        if(top2-top1 > 1){
            arr[--top2]=num;
        }
        //TC:O(n)
    }

    // Pop from stack 1 and return popped element.
    public int pop1() {

        if(top1 > -1)
            return this.arr[top1--];
        return -1;
        //TC:O(n)
    }

    // Pop from stack 2 and return popped element.
    public int pop2() {

        if(top2 < size)
            return this.arr[top2++];
        return -1;
        //TC:O(n)
    }
}
