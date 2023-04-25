package leetcode.binarysearchtree;

import java.util.Stack;

public class BSTIterator {

    private Stack<Node> st=new Stack();
    private boolean reverse=true;
    public BSTIterator(Node root, boolean rev) {
        reverse=rev;
        pushAll(root);
    }

    public void pushAll(Node root) {

        while(root!=null){
            if(!reverse)
            {
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
