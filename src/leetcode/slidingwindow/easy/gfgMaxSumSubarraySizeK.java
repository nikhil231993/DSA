package leetcode.slidingwindow.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class gfgMaxSumSubarraySizeK {

    public static void main(String[] args) {

        ArrayList<Integer> Arr=new ArrayList<>(Arrays.asList(100, 200, 300, 400));
        int K=2,N=Arr.size();

        //Approach 1: Brute for using two for loops and a length check

        //Approach 2: Brute
        System.out.println(func(K,Arr,N));

        //Approach 3: Best
        System.out.println(funcBest(K,Arr,N));
    }

    private static long funcBest(int k, ArrayList<Integer> arr, int n) {

        int left=0, right=0;
        long sum=0, maxSum=-1l;

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

        //TC:O(n)
        //SC:O(n)
    }

    public static long func(int k, ArrayList<Integer> arr, int n){

        int left=0, right=0;
        long sum=0, maxSum=-1l;

        while(right<n){
            sum+=arr.get(right);
            while(right-left+1==k){
                if(maxSum<sum){
                    maxSum=sum;
                }
                sum-=arr.get(left);
                left++;
            }
            right++;
        }
        return maxSum;

        //TC:O(2*n)
        //SC:O(n)
    }
}
