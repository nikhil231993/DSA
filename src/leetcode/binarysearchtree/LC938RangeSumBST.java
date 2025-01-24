package leetcode.binarysearchtree;

public class LC938RangeSumBST {

    //Approach 1

//    public int rangeSumBST(TreeNode root, int low, int high) {
//
//        if(root == null) return 0;
//        return func(root, low, high);
//    }
//
//    public static int func(TreeNode root, int low, int high){
//
//        if(root == null)
//          return 0;
//        if(root.val >= low && root.val <= high)
//            return root.val + func(root.left, low, high) + func(root.right, low, high);
//        else if(root.val < low)
//            return func(root.right, low, high);
//        else
//            return func(root.left, low, high);
//    }

    //Approach 2:

//    public int rangeSumBST(TreeNode root, int low, int high) {
//
//        if(root==null) return 0;
//        int[] sum=new int[1];
//        func(root, low, high, sum);
//        return sum[0];
//    }
//
//    public static void func(TreeNode root, int low, int high, int[] sum){
//        if(root==null)
//          return;
//        if(root.val>= low && root.val<=high)
//            sum[0]+=root.val;
//        func(root.left, low, high, sum);
//        func(root.right, low, high, sum);
//    }
}
