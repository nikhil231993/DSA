package leetcode.heap.codehelp;

import static leetcode.heap.codehelp.L75ConvertBSTToMinHeap.inorder;
import static leetcode.heap.codehelp.L75ConvertBSTToMinHeap.levelOrder;
import static leetcode.heap.codehelp.L75IsBinaryHeap.countNode;

public class L75ConvertBSTToMaxHeap {

    Node root;
    public static void main(String[] args) {
        L75ConvertBSTToMaxHeap l=new L75ConvertBSTToMaxHeap();
        l.root=new Node(4);
        l.root.left=new Node(2);
        l.root.right=new Node(6);
        l.root.left.left=new Node(1);
        l.root.left.right=new Node(3);
        l.root.right.left=new Node(5);
        l.root.right.right=new Node(7);

        levelOrder(l.root);

        int count=countNode(l.root);
        int[] arr=new int[count];
        int[] index=new int[]{0};

        inorder(l.root,arr,index);

        int[] newIndex=new int[]{0};
        postOrder(l.root,arr,newIndex);

        System.out.println();
        System.out.println("========================");
        //Print using level order
        levelOrder(l.root);

    }

    private static void postOrder(Node root, int[] arr, int[] newIndex) {
        if(root==null)
            return;
        postOrder(root.left,arr,newIndex);
        postOrder(root.right,arr,newIndex);
        root.value=arr[newIndex[0]++];
    }
}
