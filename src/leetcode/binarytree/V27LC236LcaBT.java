package leetcode.binarytree;

public class V27LC236LcaBT {

    //Method 1: Brute force
    //Step 1: Find the root to node a TC:O(N) SC:O(N)
    //Step 2: Find the root to node b TC:O(N) SC:O(N)
    //Step 3: Check the path of both and see which of the last element matched

    //Method 2: Recursive


//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//        if(root==null || root.val==p.val || root.val==q.val)
//            return root;
//        TreeNode left=lowestCommonAncestor(root.left, p, q);
//        TreeNode right=lowestCommonAncestor(root.right, p, q);
//        if(left==null) return right;
//        else if(right==null) return left;
//        else return root;
//    }
}
