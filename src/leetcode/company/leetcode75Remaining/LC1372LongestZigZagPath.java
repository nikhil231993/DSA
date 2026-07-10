package leetcode.company.leetcode75Remaining;

public class LC1372LongestZigZagPath {

    /*
        public int longestZigZag(TreeNode root) {
        if(root==null) return 0;
        boolean direction=false;
        int[] count=new int[1];
        recursion(root, false, count, 0);
        return count[0];
    }

    private static void recursion(TreeNode root, boolean direction, int[] count, int level){
        if(root==null) return;

        count[0]=Math.max(count[0], level);
        if(!direction){

            recursion(root.left, !direction, count, level+1);
            recursion(root.right, direction, count, 1);
        } else {
            recursion(root.right, !direction, count, level+1);
            recursion(root.left, direction, count, 1);
        }
    }
}
     */
}
