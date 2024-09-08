package leetcode.binarytree;

public class gfgChildSumInBinaryTree {

//    class Solution {
//
//        public static int isSumProperty(Node root) {
//            if (root == null || (root.left == null && root.right == null)) return 1;
//            int sum = 0;
//            if (root.left != null)
//                sum += root.left.data;
//            if (root.right != null)
//                sum += root.right.data;
//
//            if (root.data != sum) return 0;
//            if (isSumProperty(root.left) == 0)
//                return 0;
//            if (isSumProperty(root.right) == 0)
//                return 0;
//            return 1;
//        }
//    }
}
