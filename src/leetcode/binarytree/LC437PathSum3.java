package leetcode.binarytree;

public class LC437PathSum3 {

//    Approach 1

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

//    Approach 2: Aug 30 2024

//    class Solution {
//        int[] count=new int[1]; // we can use only int count=0; as it is a global variable
//        public int pathSum(TreeNode root, int targetSum) {
//            if(root==null)
//                return 0;
//            func(root, targetSum);
//            pathSum(root.left, targetSum);
//            pathSum(root.right, targetSum);
//            return count[0];
//        }
//
//        public void func(TreeNode root, int sum){
//            if(root==null || root.val==Math.pow(10,9))
//                return;
//            if(sum==root.val){
//                count[0]++;
//            }
//            func(root.left, sum-root.val);
//            func(root.right, sum-root.val);
//        }
//    }


}
