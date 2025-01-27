package leetcode.binarysearch;

public class BS4SearchInRotatedArray1LC33 {

    public static void main(String[] args) {

        int[]  num =new int[] {4,5,6,7,0,1,2};
        int target = 0;
        int pos=search(num,target);
        System.out.println(pos);
    }

    private static int search(int[] nums, int target) {

        int n=nums.length, low=0, high=n-1;

        while(low<=high){

            int mid=low+(high-low)/2;

            if(nums[mid]==target)
                return mid;

            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<=nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target>=nums[mid] && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;

        // TC:O(log n)
        // SC:O(1)
    }
}
