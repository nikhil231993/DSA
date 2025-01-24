package leetcode.binarytree;

public class V34BTFromInorderAndPreorder {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//
//        if(preorder.length==0 || inorder.length==0)
//            return null;
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i=0;i<inorder.length; i++){
//            map.put(inorder[i], i);
//        }
//        int preLen=preorder.length-1;
//        int inLen=inorder.length-1;
//        return func(preorder, 0, preLen, inorder, 0, inLen , map);
//    }
//
//    public static TreeNode func(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map){
//        if(preStart>preEnd || inStart>inEnd) return null;
//
//        TreeNode root = new TreeNode(preorder[preStart]);
//        int inRoot = map.get(preorder[preStart]);
//        int numsLeftofRootInorder = inRoot-inStart;
//        root.left = func(preorder, preStart+1, preStart+numsLeftofRootInorder, inorder, inStart, inRoot-1, map);
//        root.right = func(preorder, preStart+numsLeftofRootInorder+1, preEnd, inorder, inRoot+1, inEnd , map);
//        return root;
//
//        TC:O(N) depending on hashmap
//        SC:O(N)map + O(N) recursion stack
//    }
}
