package leetcode.binarysearchtree;

public class V49LC1008BstFromPreorder {

    //1st approach
    //Traverse through each and put the value at respective place which will be TC: O(n square)

    //2nd approach
    //find inorder by using sorting o(nlogn) and then map it which will be o(n). This
    //is using preorder and inorder combo which we have learned in BT

//    public TreeNode bstFromPreorder(int[] preorder) {
//
//        return func(preorder, Integer.MAX_VALUE, new int[]{0});
//    }
//
//    public static TreeNode func(int[] preorder, Integer max, int[] count){
//        if(count[0]==preorder.length || preorder[count[0]]>max)
//            return null;
//        TreeNode node =new TreeNode(preorder[count[0]++]);
//        node.left=func(preorder, node.val, count);
//        node.right=func(preorder, max, count);
//        return node;
//    }
    //TC: we visit single node 3 times so it is 3N
    //SC:O(1) spart from stack
}
