package leetcode.company.microsoft;

public class LC155MinStack {

    /* Approach 1
    class Node{
        int value;
        int min;
        public Node(int value, int min){
            this.value=value;
            this.min=min;
        }
    }

    class MinStack {
        Stack<Node> st=new Stack<>();
        public MinStack() {

        }

        public void push(int value) {
            if(st.isEmpty()){
                st.push(new Node(value, value));
            }else{
                st.push(new Node(value, Math.min(value, st.peek().min)));
            }
        }

        public void pop() {
            if(!st.isEmpty())
                st.pop();
        }

        public int top() {
            if(!st.isEmpty())
                return st.peek().value;
            return -1;
        }

        public int getMin() {
            return st.peek().min;
        }
    }
    */

    /* Approach 2
    class MinStack {

    Stack<Long> st=new Stack<Long>();
    long min;

    public MinStack() {

    }

    public void push(int value) {
        long val=value;
        if(st.isEmpty()){
            min=value;
            st.push(val);
        }else{
            if(val>min)
                st.push(val);
            else{
                st.push(2*val-min);
                min=val;
            }
        }
    }

    public void pop() {
        if(!st.isEmpty()){
            long x=st.pop();
            if(x<min)
                min=2*min-x;
        }
    }

    public int top() {
        if(st.isEmpty()) return -1;
        long x=st.peek();
        if(x>=min) return (int)x;
        return (int)min;
    }

    public int getMin() {
        return (int)min;
    }
}
     */
}
