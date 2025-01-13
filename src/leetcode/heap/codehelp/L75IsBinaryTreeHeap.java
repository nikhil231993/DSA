package leetcode.heap.codehelp;

class Node{

    protected int value;
    protected Node left;
    protected Node right;

    public Node(int value){
        this.value=value;
        this.left=null;
        this.right=null;
    }
}

public class L75IsBinaryTreeHeap {

    private Node root;

    public static void main(String[] args) {

        L75IsBinaryTreeHeap tree=new L75IsBinaryTreeHeap();
        tree.root=new Node(100);
        tree.root.left=new Node(90);
        tree.root.right=new Node(80);
        tree.root.left.left=new Node(40);
        tree.root.left.right=new Node(60);

//        System.out.println(tree.root.value);
//        if(tree.root.left!=null)
//            System.out.println(tree.root.left.value);
//        else
//        System.out.println("left is null");
//        System.out.println(tree.root.right.value);

            //Above we have created a custom heap
            //Below we will validate if it is a heap

        System.out.println(isHeap(tree.root));
    }

    private static boolean isHeap(Node root) {

        if(root==null)
            return true;
        int totalNodes=countNode(root);
        System.out.println(totalNodes);
        return isCBT(root,0,totalNodes) && maxHeap(root);
    }

    private static boolean maxHeap(Node root) {

        if(root.right==null && root.left==null)
            return true;
        if(root.right==null)
            return root.left.value<root.value;
        return root.left.value<root.value && root.right.value< root.value && maxHeap(root.left) && maxHeap(root.right);
    }

    private static boolean isCBT(Node root, int index, int totalNodes) {

        if(root==null)
            return true;
        if(index >= totalNodes)
            return false;
        return isCBT(root.left,2*index+1,totalNodes) && isCBT(root.right,2*index+2,totalNodes);
    }

    static int countNode(Node root) {

        if(root==null)
            return 0;
        return 1 + countNode(root.left) + countNode(root.right) ;
    }

    //TC:O(n) count nodes + O(n) cbt + O(n) for max order
    //SC:O(log N) basically height of the tree
}
