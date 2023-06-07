package leetcode.dynamicprogramming;

import java.sql.SQLOutput;
import java.util.Arrays;

public class DP42PrintLIS {

    public static void main(String[] args) {
        int[] nums =new int[] {10,9,2,5,3,6,7,101,18};
        int n=nums.length;

        print(nums,n);
    }

    private static void print(int[] nums, int n) {

        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        for(int i=0;i<n;i++)
            hash[i]=i;

        int max=1;
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],1+dp[j]);
                }
                if(dp[i]>max){
                    hash[i]=j;
                    index=i;
                    max=dp[i];
                }
            }

        }
        System.out.println("Length is: "+max);

        int variable=index;
        while(variable!=hash[variable]){
            System.out.println(nums[variable]);
            variable=hash[variable];
        }
        System.out.println(hash[variable]);
    }
    //TC:O(n square)
    //SC:O(N)

}
