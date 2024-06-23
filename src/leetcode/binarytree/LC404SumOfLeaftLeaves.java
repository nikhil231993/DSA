package leetcode.binarytree;

public class LC404SumOfLeaftLeaves {

//    public int sumOfLeftLeaves(TreeNode root) {
//        if(root==null) return 0;
//        int[] sum=new int[1];
//        dfs(root,sum,false);
//        return sum[0];
//    }
//
//    public static void dfs(TreeNode root,int[] sum, boolean isLeft){
//        if(root==null)
//            return;
//        if(isLeft && root.left==null && root.right==null){
//            sum[0]+=root.val;
//            return;
//        }
//        dfs(root.left, sum, true);
//        dfs(root.right, sum, false);
//        //TC:O(N). SC:O(H)
//    }
}
