package leetcode.binarysearchtree;

public class V48LC1008BstFromPreorder {

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
