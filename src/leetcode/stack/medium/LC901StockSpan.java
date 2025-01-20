package leetcode.stack.medium;

import java.util.Stack;

public class LC901StockSpan {

    class Node{

        public int key;
        public int span;

        public Node(int key, int span){
            this.key=key;
            this.span=span;
        }
    }

    class StockSpanner {

        Stack<Node> st=new Stack();

        public StockSpanner() {
        }

        public int next(int price) {

            int span=1;
            while(!st.isEmpty() && st.peek().key <= price){
                span+=st.peek().span;
                st.pop();
            }
            st.push(new Node(price, span));
            return span;
        }
    }
}
