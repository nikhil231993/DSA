package leetcode.array.extra;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,3,1,1,1,1,0,0,0,4,2,3,0,0,0,0,0,0,0,0};
        int k=3;

        //Optimal works for both positive, zeroes and negative
        //For negative numbers below code is the optimal
        System.out.println(maxLength(arr,k));

        //Optimal which is two pointer for positive numbers only
        System.out.println(maxLen(arr,k));
    }

    private static int maxLen(int[] arr, int k) {

        int n=arr.length;
        int r=0;
        int l=0;
        int sum=0;
        int len=0;
        while(r<n){
            sum+=arr[r];

            if(sum==k)
                len=Math.max(len,r-l+1);

            while(sum>k && l<n){
                sum-=arr[l];
                l++;

                if(sum==k)
                    len=Math.max(len,r-l+1);
            }
            r++;
        }
        return len;

        //TC:O(2N)
        //SC:O(1)
    }

    private static int maxLength(int[] arr,int k) {

        int maxLen=0;

        HashMap<Integer,Integer> map=new LinkedHashMap<>();
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum==k)
                maxLen=Math.max(maxLen,i+1);

            if(map.containsKey(sum-k))
                maxLen=Math.max(maxLen,i-map.get(sum-k));

            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return maxLen;

        //TC:O(N)
        //SC:O(N)
    }
}
