package leetcode.binarysearch;

public class BS9FindPeakElementLC162 {

    public static void main(String[] args) {

        int[] nums=new int[]{1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {

        int n=nums.length;
        if(n==1)
            return 0;
        if(nums[0]>nums[1])
            return 0;
        if(nums[n-1]>nums[n-2])
            return (n-1);

        int low=1, high=n-2;
        while(low<=high){

            int mid=low+(high-low)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            if(nums[mid] > nums[mid-1]) //Here >= also works
                low=mid+1;
            else  // Check here is removed from here
                high=mid-1;
        }
        return -1;

        //TC:O(log n)
        //SC:O(1)
    }
}
