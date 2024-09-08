package leetcode.binarytree;

public class LC113PathSum2 {

//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//
//        List<List<Integer>> list=new ArrayList();
//        func(root, targetSum, 0, list, new ArrayList());
//        return list;
//    }
//
//    public static void func(TreeNode root, int sum, int s, List<List<Integer>> list, List<Integer> ans){
//        if(root==null)
//            return;
//        s+=root.val;
//        ans.add(root.val);
//        if(s == sum && root.left == null && root.right == null)
//            list.add(new ArrayList(ans));
//        func(root.left, sum, s, list, ans);
//        func(root.right, sum, s, list, ans);
//        ans.remove(ans.size()-1);
//    }
}
