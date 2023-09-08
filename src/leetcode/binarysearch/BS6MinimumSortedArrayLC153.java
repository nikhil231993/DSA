package leetcode.binarysearch;

public class BS6MinimumSortedArrayLC153 {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,5};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {

        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;

            //if below condition is true that means it is the pivot point and low will be the anser
            if(nums[low]<=nums[high]){
                ans=Math.min(ans,nums[low]);
                break;
            }

            if(nums[low]<=nums[mid]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }
        return ans;
        //TC:O(log n)
        //SC:O(1)
    }
}
