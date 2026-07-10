package leetcode.company.leetcode75Remaining;

public class LC1161MaximumLevelSumBinaryTree {

    /*
    class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int level=0, maxLevel=0;
        int max=Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int n=q.size();
            int sum=0;
            level++;
            for(int i=0;i<n;i++){
                TreeNode node =q.poll();
                sum+=node.val;
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            if(sum>max){
                max=sum;
                maxLevel=level;
            }
        }
        return maxLevel;
    }
}
     */
}
