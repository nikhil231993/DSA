package leetcode.binarytree;

public class V35BTFromInorderAndPostorder {

//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//
//        Map<Integer, Integer> map=new HashMap();
//        for(int i=0;i< inorder.length; i++)
//            map.put(inorder[i], i);
//        TreeNode node=buildingTree(postorder, 0, postorder.length-1,
//                inorder, 0, inorder.length-1,  map);
//        return node;
//    }
//
//    public static TreeNode buildingTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map){
//        if(inStart>inEnd || postStart>postEnd)
//            return null;
//
//        TreeNode node=new TreeNode(postorder[postEnd]);
//        int inRoot=map.get(postorder[postEnd]);
//        int numLeft=inRoot-inStart;
//
//        node.left=buildingTree(postorder, postStart, postStart+numLeft-1, inorder, inStart, inRoot-1,map);
//
//        node.right=buildingTree(postorder,postStart+numLeft, postEnd-1, inorder, inRoot+1, inEnd, map );
//
//        return node;
//
//        //TC:O(N) depending on hashmap
//        //SC:O(N)map +O(N) recursion stack
//    }
}
