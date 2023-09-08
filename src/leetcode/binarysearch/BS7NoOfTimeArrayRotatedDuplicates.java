package leetcode.binarysearch;

public class BS7NoOfTimeArrayRotatedDuplicates {

    public static void main(String[] args) {

        int[] arr =new int[] { 3,3,1,3};
        int n =arr.length;
        System.out.println(findKRotation(arr,n));
    }

    public static int findKRotation(int nums[], int n) {
        int low=0;
        int high=nums.length-1;
        int ans=Integer.MAX_VALUE;
        int index=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;

//            if(nums[low]<=nums[high]){
//                if(ans>nums[low]){
//                    ans=nums[low];
//                    index=low;
//                    break;
//                }
//            }

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
    }
}
