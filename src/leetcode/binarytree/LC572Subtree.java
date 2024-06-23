package leetcode.binarytree;

public class LC572Subtree {

//    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
//
//        if(root==null && subRoot==null)
//            return true;
//        if(root==null && subRoot!=null)
//            return false;
//        if(root!=null && subRoot==null)
//            return false;
//        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
//
//    }
//    public static boolean isSame(TreeNode p, TreeNode q) {
//        if(p ==null && q == null )
//            return true;
//        if(p ==null || q == null)
//            return false;
//        if(p.val != q.val)
//            return false;
//        return isSame(p.left,q.left) && isSame(p.right,q.right);
//        //TC:O(N) SC:O(N)
//    }
}
