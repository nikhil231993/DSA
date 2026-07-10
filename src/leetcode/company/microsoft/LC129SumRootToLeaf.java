package leetcode.company.microsoft;

public class LC129SumRootToLeaf {

    /*public int sumNumbers(TreeNode root) {

        List<Integer> list=new ArrayList();
        func(root, list, 0);
        int sum=0;
        for(Integer num:list)
            sum+=num;
        return sum;
    }

    public static void func(TreeNode root, List<Integer> list, int currentSum){
        if(root==null)
            return;
        currentSum = currentSum * 10 + root.val;
        if(root.left==null && root.right==null)
            list.add(currentSum);
        func(root.left, list, currentSum);
        func(root.right, list, currentSum);
    }
     */
}
