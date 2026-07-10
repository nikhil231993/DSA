package leetcode.company.leetcode75Remaining;

public class LC1448CountGoodNoesInBinaryTree {

    /*
    class Solution {

    public int goodNodes(TreeNode root) {
         if(root==null) return 0;
          int[] count=new int[1];
          func(root, root.val, count);
          return count[0];
    }

    private void func(TreeNode root, int max, int[] count){

        if(root==null) return;
        if(root.val>=max)
            count[0]++;
        max=Math.max(max, root.val);
        func(root.left, max, count);
        func(root.right, max, count);
    }
}
     */
}
