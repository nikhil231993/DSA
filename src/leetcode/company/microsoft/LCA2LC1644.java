package leetcode.company.microsoft;

public class LCA2LC1644 {

    /*
    //Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes, p and q. If either node p or q does not exist in the tree, return null. All values of the nodes in the tree are unique.
    //
    //According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a binary tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)". A descendant of a node x is a node y that is on the path from node x to some leaf node.

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            boolean[] found=new boolean[2];
            TreeNode lca=func(root, p ,q, found);
            return (found[0] && found [1])?lca:null;
        }

        private TreeNode func(TreeNode root, TreeNode p, TreeNode q, boolean[] found){

            if(root==null)
                return root;
            TreeNode left=func(root.left, p, q, found);
            TreeNode right=func(root.right, p, q, found);
            if(root.val==p.val){
                found[0]=true;
                return root;
            }
            if(root.val==q.val){
                found[1]=true;
                return root;
            }
            if(left==null)
                return right;
            else if(right==null)
                return left;
            return root;
        }
    }
     */
}
