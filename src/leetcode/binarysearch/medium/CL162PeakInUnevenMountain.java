package leetcode.binarysearch.medium;

public class CL162PeakInUnevenMountain {

    public static void main(String[] args) {

        int[] num=new int[]{1,2,1,3,5,6,4};

        System.out.println(peak(num));
    }

    private static int peak(int[] num) {

        int low=0;
        int high=num.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid==num.length-1 ||num[mid]>num[mid+1] )&&(mid==0|| num[mid]>num[mid-1])){
                return mid;
            }else if(num[mid]<num[mid+1]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
