package leetcode.binarysearchtree;

import java.util.Stack;

public class V50BSTIteratorOnly {

    private Stack<Node> st=new Stack();

    private V50BSTIteratorOnly(Node root, boolean rev) {
        pushAll(root);
    }

    private void pushAll(Node root) {

        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }

    private int next(){
        Node node=st.pop();
        pushAll(node.right);
        return node.data;
    }

    private boolean hasNext() {
        return !st.isEmpty();
    }
}
