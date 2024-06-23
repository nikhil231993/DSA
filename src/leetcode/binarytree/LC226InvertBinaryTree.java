package leetcode.binarytree;

public class LC226InvertBinaryTree {

    //Approach 1: Iterative
//    public TreeNode invertTree(TreeNode root) {
//
//        if(root==null)
//            return null;
//        Queue<TreeNode> q=new LinkedList();
//        q.offer(root);
//        while(!q.isEmpty()){
//            TreeNode node=q.poll();
//            TreeNode temp=node.left;
//            node.left=node.right;
//            node.right=temp;
//
//            if(node.left!=null)
//                q.offer(node.left);
//            if(node.right!=null)
//                q.offer(node.right);
//        }
//        return root;
//    }

    //Approach 2:

//    public TreeNode invertTree(TreeNode root) {
//
//        if(root==null) return null;
//
//        invertTree(root.left);
//        invertTree(root.right);
//        TreeNode temp=root.left;
//        root.left=root.right;
//        root.right=temp;
//        return root;
//    }
}
