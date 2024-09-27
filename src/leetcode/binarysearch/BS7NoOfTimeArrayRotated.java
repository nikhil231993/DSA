package leetcode.binarysearch;

public class BS7NoOfTimeArrayRotated {

    public static void main(String[] args) {

        int n = 13;
        int[] arr =new int[] { 66, 67, 7, 10 ,14, 19, 27, 33, 36, 40, 44, 54, 60};
        System.out.println(findKRotation(arr,n));
    }

    public static int findKRotation(int nums[], int n) {

        int low=0, high=n-1, ans=Integer.MAX_VALUE, index=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[low]<=nums[high]){
                if(ans>nums[low]){
                    ans=nums[low];
                    index=low;
                    break;
                }
            }
            if(nums[low]<=nums[mid]){
                if(ans>nums[low]){
                    ans=nums[low];
                    index=low;
                }
                low=mid+1;
            }else{
                if(ans>nums[mid]){
                    ans=nums[mid];
                    index=mid;
                }
                high=mid-1;
            }
        }
        return index;

        //TC:O(log n)
        //SC:O(1)
    }
}
