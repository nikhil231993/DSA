package leetcode.binarysearch;

public class BS5SearchInRotatedArray2LC81 {

    public static void main(String[] args) {
        int[] nums=new int[]{1};;
        int target=1;
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
        else if(nums[low]==nums[mid] && nums[mid]==nums[high]){
            low++;
            high--;
        }else if(nums[low]<=nums[mid]){
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
    //TC:O(n/2) in case array has many duplicates
    }
}
