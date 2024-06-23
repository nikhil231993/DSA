package leetcode.binarytree;

public class LC257BinaryTreePaths {

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
//        //TC:o(logn) or O(h)
//        //Tc:O(H)
//    }
}
