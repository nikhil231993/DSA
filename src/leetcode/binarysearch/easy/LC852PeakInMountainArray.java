package leetcode.binarysearch.easy;

public class LC852PeakInMountainArray {

    public static void main(String[] args) {

        int[] num=new int[]{1,2,3,4,5,6,7,8,6,5,4};
        System.out.println(peak(num));
    }

    private static int peak(int[] arr) {

        //Here we need to understand that if we go to max value side we will find the peak element as it cannot be on the
        //other side which is less basically left side

            int n=arr.length;
            if(n==1)
                return 0;
            if(arr[0]>arr[1])
                return 0;
            if(arr[n-1]>arr[n-2])
                return n-1;
            int low=1;
            int high=arr.length-2;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                    return mid;
                else if(arr[mid]>arr[mid-1])
                    low=mid+1;
                else
                    high=mid-1;
            }
            return -1;

        //TC:O(logn)
    }
}
