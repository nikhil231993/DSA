package leetcode.binarysearch;

public class BS3FirstAndLastPositionLC34 {

    public static void main(String[] args) {

        //Approach 1:
        //We can do below by using linear search as brute force where first and last will be -1.
        //last keeps on updating whenever we find value equal to x but first updates only 1 time using first==-1 check

        //Approach 2: Best
        int[] num =new int[]{2,4,6,8,8,8,11,13};
        int target=8;
        int[] result=searchRange(num,target);

        for(int n : result)
            System.out.println(n);
    }

    public static int[] searchRange(int[] nums, int target) {

        int first = firstOccurrence(nums,target);
        int last = lastOccurrence(nums,target);
        return new int[]{ first, last };
    }

    private static int lastOccurrence(int[] nums, int target) {

        int low=0, high=nums.length-1, ans=-1;

        while(low<=high){

            int mid=low+(high-low)/2;
            if(nums[mid]==target) {
                ans = mid;
                low = mid + 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low=mid+1;
            }
        }
        return ans;

        // TC:O(log n)
        // SC:O(1)
    }

    private static int firstOccurrence(int[] nums, int target) {

        int low=0, high=nums.length-1, ans=-1;

        while(low<=high){

            int mid=low+(high-low)/2;
            if(nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low=mid+1;
            }
        }
        return ans;

        //TC:O(log n)
        //SC:O(1)
    }
}
