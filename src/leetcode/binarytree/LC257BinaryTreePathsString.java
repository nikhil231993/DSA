package leetcode.binarytree;

public class LC257BinaryTreePathsString {

    /*
    In this case since string is immutable the value of string does not change when we go only left or right,
    whereas in case list since it is pass by reference its value changes due to which we have to remove the elements
    while backtracking
     */

//    public List<String> binaryTreePaths(TreeNode root) {
//
//        if(root==null)
//            return new ArrayList();
//        List<String> paths=new ArrayList();
//        dfs(paths, "",root);
//        return paths;
//    }
//
//    public static void dfs(List<String> paths, String path, TreeNode root){
//        if(root==null)
//            return;
//        path+=root.val;
//        if(root.left==null && root.right==null)
//            paths.add(path);
//        dfs(paths, path+"->", root.left);
//        dfs(paths, path+"->", root.right);
//
//        //TC:O(nlogn) because O(n) for parsing each node and logn is to add the string into result as the
          // length of teh string is can be from h =height of the tree to n = skewed tree
          // so h=logn which is height of the tree
//        //SC:O(H)
//    }
}
