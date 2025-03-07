package leetcode.array.easy;

public class LC674LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {

        int[] nums =new int[] {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }

    public static int findLengthOfLCIS(int[] nums) {

        int count=0;
        int prev=-1;
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prev<nums[i]){
                count++;
                prev=nums[i];
            }else{
                prev=nums[i];
                count=1;
            }
            max=Math.max(max, count);
        }
        return max;
    }
}
