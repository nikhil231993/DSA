package leetcode.binarytree;

public class LC437PathSum3 {

//    private  int[] count=new int[1];
//    public int pathSum(TreeNode root, int targetSum) {
//
//        if(root==null)
//            return 0;
//        int sum=0;
//        helper(root,targetSum,0);
//        pathSum(root.left,targetSum);
//        pathSum(root.right,targetSum);
//        return count[0];
//    }
//
//    public  void helper(TreeNode root, int sum, int s){
//
//        if(root==null || root.val == Math.pow(10,9))
//            return ;
//
//        s+=root.val;
//        if(s==sum)
//            count[0]++;
//
//        helper(root.left, sum, s);
//        helper(root.right, sum, s);
//
//        TC:o(n*n) sc:o(logn)
//    }
}
