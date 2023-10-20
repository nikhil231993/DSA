package leetcode.heap.codehelp;

import java.util.LinkedList;
import java.util.Queue;
public class L75ConvertBSTToMinHeap {
    Node root=null;
    public static void main(String[] args) {

        L75ConvertBSTToMinHeap tree=new L75ConvertBSTToMinHeap();
        tree.root=new Node(4);
        tree.root.left=new Node(2);
        tree.root.right=new Node(6);
        tree.root.left.left=new Node(1);
        tree.root.left.right=new Node(3);
        tree.root.right.left=new Node(5);
        tree.root.right.right=new Node(7);

        //Print using level order
        levelOrder(tree.root);

        int count=countNode(tree.root);
        int[] arr=new int[count];
        int[] index=new int[]{0};

        //Steps:
        //1. Find inorder of BST which be default is sorted
        //2. based on two conditions N<L and N<R which is of min heap
        // and L<R from question so the equation is N<L<R which is same as converting inorder result to preorder traversal

        //Step 1. Below will return sorted order
        inorder(tree.root,arr,index);

        //Step 2. Below will create tree where left< right
        int[] newIndex=new int[]{0};
        preorder(tree.root,arr,newIndex);

        System.out.println();
        System.out.println("========================");
        //Print using level order
        levelOrder(tree.root);
    }

    public static void levelOrder(Node root) {
        if(root==null)
            return;
        else {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                Node temp = q.peek();
                q.remove();
                System.out.print(temp.value + "-->");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
    }

    private static void preorder(Node root, int[] arr, int[] newIndex) {
        if(root==null)
            return;
        root.value=arr[newIndex[0]++];
        preorder(root.left,arr,newIndex);
        preorder(root.right,arr,newIndex);
    }

    public static int countNode(Node root) {
        if(root==null)
            return 0;
        int left=countNode(root.left);
        int right=countNode(root.right);
        return 1+left+right;
    }

    public static void inorder(Node root,int[] arr,int[] index){
        if(root==null)
            return;
        inorder(root.left,arr,index);
        arr[index[0]++]=root.value;
        inorder(root.right,arr,index);
    }
}
