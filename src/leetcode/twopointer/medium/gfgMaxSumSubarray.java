package leetcode.twopointer.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class gfgMaxSumSubarray {

    public static void main(String[] args) {

        ArrayList<Integer> Arr=new ArrayList<>(Arrays.asList(100, 200, 300, 400));
        int K=2,N=Arr.size();
        System.out.println(func(K,Arr,N));
    }

    public static long func(int k, ArrayList<Integer> arr, int n){

        int left=0, right=0;
        long sum=0;
        long maxSum=-1l;

        while(right<n){
            sum+=arr.get(right);
            if(right-left+1==k){
                if(maxSum<sum){
                    maxSum=sum;
                }
                sum-=arr.get(left);
                left++;
            }
            right++;
        }
        return maxSum;
    }
}
