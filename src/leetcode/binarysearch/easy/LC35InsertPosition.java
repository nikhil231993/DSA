package leetcode.binarysearch.easy;

public class LC35InsertPosition {
    public static void main(String[] args) {
        int[] nums =new int[] {1,3,5,6};
        int target = 5;

        System.out.println(searchInsert(nums,target));
    }


    public static int searchInsert(int[] nums, int target) {

        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target) {
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;

        //TC:o(logn)
        //SC:O(1)

    }
}
