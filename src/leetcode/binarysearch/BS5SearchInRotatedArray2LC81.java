package leetcode.binarysearch;

public class BS5SearchInRotatedArray2LC81 {

    public static void main(String[] args) {

        //NOTE: Index can be found using only linear search

        int[] nums=new int[]{7,8,1,2,3,3,3,4,5,6};
        //int[] nums=new int[]{3,1,2,3,3,3,3,3};
        int target=3;
        System.out.println(search(nums,target));
    }

    public static boolean search(int[] nums, int target) {

        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){

            int mid=low+(high-low)/2;

            if(nums[mid]==target)
                return true;

            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<=nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target>=nums[mid] && target <=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
		return false;

        //TC:O(n/2) worst case, in case array has many duplicates as we keep on shrinking
        //SC:O(1)
    }
}
