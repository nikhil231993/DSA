package leetcode.binarysearchtree;

public class V49LC1008BstFromPreorder {

    //1st approach
    //Traverse through each and put the value at respective place which will be o(n sqaure)

    //2nd approach
    //find inorder by using sorting o(nlogn) and then map it which will be o(n)

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
}
