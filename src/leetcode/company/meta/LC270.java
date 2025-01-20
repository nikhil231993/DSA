package leetcode.company.meta;

public class LC270 {

//    public int closestValue(TreeNode root, double target) {
//
//        int[] closest=new int[1];
//        closest[0]=Integer.MAX_VALUE;
//        double[] min=new double[1];
//        min[0]=Integer.MAX_VALUE;
//        func(root, target, closest, min);
//        return closest[0];
//    }
//
//    public static void func(TreeNode root, double target, int[] closest, double[] min){
//
//        if(root==null)
//            return ;
//        if(Math.abs(target-root.val)<min[0]){
//            min[0]=Math.abs(target-root.val);
//            closest[0]=root.val;
//        }
//        if(Math.abs(target-root.val)==min[0]){
//            closest[0]=Math.min(root.val, closest[0]);
//        }
//        func(root.left, target, closest, min);
//        func(root.right, target, closest, min);
//    }
}
