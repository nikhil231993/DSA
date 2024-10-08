package leetcode.binarysearchtree;

import java.util.Stack;

public class V50BSTIterator {

    private Stack<Node> st=new Stack();
    private boolean reverse=true;
    //reverse false means small
    //revers true means large

    public V50BSTIterator(Node root, boolean rev) {
        reverse=rev; // This code is for Two Sum
        pushAll(root);
    }

    public void pushAll(Node root) {

        while(root!=null){
            if(!reverse) {
                st.push(root);
                root=root.left;
            }else{
                st.push(root);
                root=root.right;
            }
        }
    }

    public  int next(){
        Node node=st.pop();
        if(!reverse){
            pushAll(node.right);
        }else{
            pushAll(node.left);
        }
        return node.data;
    }
}
