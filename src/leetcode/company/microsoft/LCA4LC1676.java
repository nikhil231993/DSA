package leetcode.company.microsoft;

public class LCA4LC1676 {

    /*
    //Given the root of a binary tree and an array of TreeNode objects nodes, return the lowest common ancestor (LCA) of all the nodes in nodes. All the nodes will exist in the tree, and all values of the tree's nodes are unique.
    //
    //Extending the definition of LCA on Wikipedia: "The lowest common ancestor of n nodes p1, p2, ..., pn in a binary tree T is the lowest node that has every pi as a descendant (where we allow a node to be a descendant of itself) for every valid i". A descendant of a node x is a node y that is on the path from node x to some leaf node.

    class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set=new HashSet<>(Arrays.asList(nodes));
        return func(root, set);
    }

    private TreeNode func(TreeNode root, Set<TreeNode> set){
        if(root==null) return root;
        TreeNode left=func(root.left, set);
        TreeNode right=func(root.right, set);
        if(set.contains(root)) return root;
        if(left==null)
            return right;
        else if(right==null)
            return left;
        return root;
    }
}
     */
}
