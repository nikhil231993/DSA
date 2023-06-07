package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP47LC673NoOfLIS {

    public static void main(String[] args) {
        int[] nums=new int[]{1,5,4,3,2,6,7,2};
        int n=nums.length;

        System.out.println(noOfLIS(nums,n));
    }

    private static int noOfLIS(int[] nums, int n) {

        int[] dp=new int[n];
        Arrays.fill(dp,1);

        int[] count=new int[n];
        Arrays.fill(count,1);

        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[j]+1>dp[i]){
                    dp[i]=1+dp[j];
                    count[i]=count[j];
                }else if(nums[i]>nums[j] && dp[j]+1==dp[i]){
                    count[i]=count[i]+ count[j];
                }
            }
            max=Math.max(dp[i],max);
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max)
                cnt+=count[i];
        }
        return cnt;
    }
}
