package leetcode.binarysearchtree;

public class LC108ConvertSortedArrayToBST {

//    public TreeNode sortedArrayToBST(int[] nums) {
//        return func(nums, 0, nums.length-1);
//    }
//
//    public static TreeNode func(int[] nums, int low, int high){
//        if(low>high) return null;
//        int mid = (low+(high-low)/2);
//        TreeNode node = new TreeNode(nums[mid]);
//        node.left = func(nums, low, mid-1);
//        node.right = func(nums, mid+1, high);
//        return node;
//    }
}
