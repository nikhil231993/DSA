package leetcode.company.leetcode75Remaining;

public class LC209MinimizeSubarraySum {

    public static void main(String[] args) {
       int target = 7;
       int[] nums = new int[] {2,3,1,2,4,3};
       System.out.println(minSubArrayLen(target, nums));
    }

    private static int minSubArrayLen(int target, int[] nums) {
        int left=0, right=0, n=nums.length;
        int minLen=Integer.MAX_VALUE, sum=0;

        while(right<n){
            sum+=nums[right];

            while(sum>=target){
                minLen=Math.min(minLen, right-left+1);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}
