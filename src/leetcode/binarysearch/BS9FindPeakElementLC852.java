package leetcode.binarysearch;

public class BS9FindPeakElementLC852 {

    public static void main(String[] args) {
        int[] arr=new int[]{0,10,5,2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    public static int peakIndexInMountainArray(int[] arr) {

        int n=arr.length-1;
        int low = 1, high = n-1;
        if(arr[0]>arr[1])
            return 0;
        if(arr[n]>arr[n-1])
            return n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            if(arr[mid]>arr[mid-1])
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
        //TC:O(log n)
        //SC:o(1)
    }
}
