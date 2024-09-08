package leetcode.binarytree;

public class LC617MergeTwoBinaryTrees {

//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        return func(root1, root2);
//    }
//
//    public static TreeNode func(TreeNode root1, TreeNode root2){
//
//        if(root1==null && root2==null) return null;
//        if(root1==null)
//            return root2;
//        if(root2==null)
//            return root1;
//        TreeNode node=new TreeNode(root1.val+root2.val);
//        node.left=func(root1.left, root2.left);
//        node.right=func(root1.right, root2.right);
//        return node;
//    }
}
