package src.leetcode.array.easy;

public class LC1991 {

    public static void main(String[] args) {
        int[] nums = new int[] { 2,3,-1,8,4 };
        System.out.println(new LC1991().findMiddleIndex(nums));
    }

    public int findMiddleIndex(int[] nums) {
        int sum=0;
        int leftSum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        for(int i=0;i<nums.length;i++){
            if(sum-(2*leftSum)==nums[i])
                return i;
            leftSum+=nums[i];
        }
        return -1;

        //TC: O(n)
        //SC: O(1)
    }
}
