package leetcode.twopointer.striver;

public class V4MaxOnesLC1004 {

    public static void main(String[] args) {

        int[] nums =new int[] {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;

        //Approach 1: Brute
        System.out.println(brute(nums, k));

        //Approach 2: Better
        System.out.println(maxOnesBetter(nums, k));

        //Approach 3: Best
        System.out.println(longestOnesBest(nums, k));
    }

    private static int maxOnesBetter(int[] nums, int k) {

        Integer maxLen=Integer.MIN_VALUE;

        int right=0, left=0, count=0, n=nums.length;

        while(right<n){

            if(nums[right]==0)
                count++;

            while(count > k){
                if(nums[left]==0)
                    count--;
                left++;
            }

            if(count<=k)
                maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;

        //TC:O(n)+O(n)
        //SC:O(1)
    }

    private static int brute(int[] nums, int k) {

        int n=nums.length;
        Integer maxLen=Integer.MIN_VALUE;

        for(int i=0; i<n;i++){

            int count=0;
            for(int j=i;j<n;j++){
                if(nums[j]==0){
                    count++;
                }
                if(count<=k){
                    maxLen=Math.max(maxLen, j-i+1);
                }else
                    break;
            }
        }
        return maxLen;

        //TC:O(n square)
        //SC:O(1)
    }

    public static int longestOnesBest(int[] nums, int k) {

        Integer maxLen=Integer.MIN_VALUE;
        int right=0, left=0, count=0, n=nums.length;

        while(right<n)
        {
            if(nums[right]==0)
                count++;
            if(count>k){
                if(nums[left]==0)
                    count--;
                left++;
            }
            if(count<=k)
                maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;

        //TC:O(n)
        //SC:O(1)
    }
}
