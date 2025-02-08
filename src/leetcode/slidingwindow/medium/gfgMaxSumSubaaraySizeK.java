package leetcode.slidingwindow.medium;

public class gfgMaxSumSubaaraySizeK {

    public static void main(String[] args) {

        int[] arr=new int[]{100, 200, 300, 400};
        int k=2;

        System.out.println(maximumSumSubarray(arr, k));
    }

    public static int maximumSumSubarray(int[] arr, int k) {

        int n=arr.length;
        int r=0, l=0, max=Integer.MIN_VALUE, sum=0;

        while(r<n){

            sum+=arr[r];
            while((r-l+1)>k){
                sum-=arr[l];
                l++;
            }

            if((r-l+1)<=k)
                max=Math.max(max, sum);
            r++;
        }
        return max;
    }
}
