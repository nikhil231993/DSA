package leetcode.binarytree;

public class LC2385AmountOfTimeToInfect {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
//    class Solution {
//        public int amountOfTime(TreeNode root, int start) {
//
//            Map<TreeNode, TreeNode> parent = new HashMap();
//            TreeNode target = parentMapping(parent, root, start);
//
//            Queue<TreeNode> q = new LinkedList();
//            q.offer(target);
//
//            Map<TreeNode, Boolean> visited = new HashMap();
//            visited.put(target, true);
//            int count = 0;
//            int max=0;
//            while (!q.isEmpty()) {
//                count++;
//                int flag = 0;
//                int size = q.size();
//
//                for (int i = 0; i < size; i++) {
//                    TreeNode node = q.poll();
//                    if (node.left != null && visited.get(node.left) == null) {
//                        flag = 1;
//                        q.offer(node.left);
//                        visited.put(node.left, true);
//                    }
//
//                    if (node.right != null && visited.get(node.right) == null) {
//                        flag = 1;
//                        q.offer(node.right);
//                        visited.put(node.right, true);
//                    }
//
//                    if (parent.get(node) != null && visited.get(parent.get(node)) == null) {
//                        flag = 1;
//                        q.offer(parent.get(node));
//                        visited.put(parent.get(node), true);
//                    }
//                }
//
//                if (flag == 1) {
//                    max++;
//                }
//            }
//            return count-1;
//        }
//
//        public static TreeNode parentMapping(Map<TreeNode, TreeNode> parent, TreeNode root, int start) {
//
//            Queue<TreeNode> q = new LinkedList();
//            q.add(root);
//            TreeNode temp = null;
//            while (!q.isEmpty()) {
//                int size = q.size();
//
//                for (int i = 0; i < size; i++) {
//                    TreeNode node = q.poll();
//                    if (start == node.val) {
//                        temp = node;
//                    }
//                    if (node.left != null) {
//                        q.offer(node.left);
//                        parent.put(node.left, node);
//                    }
//
//                    if (node.right != null) {
//                        q.offer(node.right);
//                        parent.put(node.right, node);
//                    }
//                }
//            }
//            return temp;
//        }
//    }
}
