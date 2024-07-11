package leetcode.binarysearch;

public class BS7NoOfTimeArrayRotatedDuplicates {

    public static void main(String[] args) {

        int[] arr =new int[] { 3,4,5,1,2};
        int n =arr.length;
        System.out.println(findKRotation(arr,n));
    }

    public static int findKRotation(int nums[], int n) {

        int low=0, high=n-1, ans=Integer.MAX_VALUE, index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            //Add below block only to optimize if needed
            if(nums[low]<nums[high]){
                if(ans>nums[low]) {
                    ans = nums[low];
                    index = low;
                }
                break;
            }

            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                if(ans>nums[low]){
                    ans=nums[low];
                    index=low;
                }
                low++;
                high--;
                continue;
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

        //TC:O(n/2)
        //SC:O(1)
    }
}
