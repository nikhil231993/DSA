package leetcode.binarysearch;

public class BS6MinimumSortedArray1LC153 {

    public static void main(String[] args) {

        int[] num=new int[]{1,2,3,4,5};
        System.out.println(findMin(num));
    }

    public static int findMin(int[] nums) {

        int n=nums.length, low=0, high=n-1, ans=Integer.MAX_VALUE;

        while(low<=high){

            int mid=low+(high-low)/2;

            //if below condition is true that means it is the pivot point and low will be the answer
            if(nums[low]<=nums[high]){
                ans=Math.min(ans, nums[low]);
                break;
            }
            //for array like this where l, m will point to 2 and h will point to 1 i.e [2,1] we need <=
            if(nums[low]<=nums[mid]){
                ans=Math.min(ans, nums[low]);
                low=mid+1;
            }else{
                ans=Math.min(ans, nums[mid]);
                high=mid-1;
            }
        }
        return ans;

        //TC:O(log n)
        //SC:O(1)
    }
}
