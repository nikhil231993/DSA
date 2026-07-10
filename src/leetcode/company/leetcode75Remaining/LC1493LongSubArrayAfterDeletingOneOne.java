package leetcode.company.leetcode75Remaining;

public class LC1493LongSubArrayAfterDeletingOneOne {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }

    private static int longestSubarray(int[] nums) {
        int n=nums.length;
        int count=0;
        int maxLen=0;
        int left=0, right=0;
        while(right<n){

            if(nums[right]==0)
                count++;

            if(count>1){
                if(nums[left]==0)
                    count--;
                left++;
            }
            if(count<=1)
                maxLen=Math.max(maxLen, right-left);
            right++;
        }
        return maxLen;
    }
}
