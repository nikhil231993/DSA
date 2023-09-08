package leetcode.binarysearch;

public class BS6MinimumSortedArrayLC154 {

    public static void main(String[] args) {
        int[] nums=new int[]{3,3,1,3};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {

        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[low]==nums[mid] && nums[mid]==nums[high])
            {
                ans=Math.min(ans,nums[low]);
                low++;
                high--;
                continue;
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


        //TC:O(n/2)
        //SC:O(1)

    }
}
