package leetcode.company.leetcode75Remaining;

public class LC872LeafSimilarTrees {

    /*
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafList1=new ArrayList<>();
        List<Integer> leafList2=new ArrayList<>();
        dfs(root1, leafList1);
        dfs(root2, leafList2);
        return leafList1.equals(leafList2);
    }

    private static void dfs(TreeNode root, List<Integer> list){
        if(root==null) return;
        if(root.left==null && root.right==null)
            list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
        }
    }
     */
}
