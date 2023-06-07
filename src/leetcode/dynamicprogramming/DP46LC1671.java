package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP46LC1671 {
    public static void main(String[] args) {
        int[] nums=new int[]{2,1,1,5,6,2,3,1};
        int n=nums.length;

        System.out.println(n-longestBitonic(nums, n));
    }

    private static int longestBitonic(int[] arr, int n) {
        int[] dp1=new int[n];
        Arrays.fill(dp1,1);

        int[] dp2=new int[n];
        Arrays.fill(dp2,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && 1+dp1[j]>dp1[i]){
                    dp1[i]=1+dp1[j];
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[i]>arr[j] && 1+dp2[j]>dp2[i]){
                    dp2[i]=1+dp2[j];
                }
            }
        }

        int max=0;
        for(int i=0;i<n;i++){
            //Below condition is added or else we might get only strictly increasing or strictly decreasing sequence
            //which will not be mountain
            if(dp1[i]>1 && dp2[i]>1)
                max=Math.max(max,dp1[i]+dp2[i]-1);
        }
        return max;
    }
}
