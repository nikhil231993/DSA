package leetcode.binarysearch.easy;

public class LC852PeakInMountainArray {

    public static void main(String[] args) {

        int[] num=new int[]{1,2,3,4,5,6,7,8,6,5,4};
        System.out.println(peak(num));
    }

    private static int peak(int[] num) {

        //Here we need to understand that if we go to max value side we will find the peak element as it cannot be on the
        //other side which is less basically left side

        int left=0;
        int right=num.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(num[mid]<num[mid+1]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;

        //TC:O(logn)
    }
}
