package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP42PrintLIS {

    public static void main(String[] args) {

        int[] nums =new int[] {10,9,2,5,3,6,7,101,18};
        nums=new int[]{5,6,3,4,7,6};
        int n=nums.length;

        System.out.println(print(nums,n));
    }

    private static List<Integer> print(int[] nums, int n) {

        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        for(int i=0;i<n;i++)
            hash[i]=i;

        int max=1;
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<1+dp[j]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
                if(dp[i]>max){
                    index=i;
                    max=dp[i];
                }
            }
        }
        System.out.println("Length is: "+max);

        List<Integer> list=new ArrayList<>();
        int variable=index;
        list.add(0,nums[variable]);
        while(variable!=hash[variable]) {
            variable = hash[variable];
            list.add(0,nums[variable]);
        }
        return list;

        //TC:O(n square)
        //SC:O(N)
    }
}
