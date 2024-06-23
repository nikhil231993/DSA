package leetcode.binarytree;

public class LC122PathSum {

//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if(root==null) return false;
//        int s=0;
//        return func(root, targetSum, s);
//    }
//
//    public static boolean func(TreeNode root, int sum, int s){
//
//        if(root==null) return false;
//        s+=root.val;
//        if(s==sum && root.left==null && root.right==null) return true;
//        if(func(root.left, sum, s)) return true;
//        if(func(root.right, sum, s)) return true;
//        return false;
//    }
}
