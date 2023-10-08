package leetcode.binarysearch;

public class BS3CountOccurences {

    public static void main(String[] args) {

        int[] num =new int[]{2,4,6,8,8,8,11,13};
        int target=8;
        int[] result=searchRange(num,target);
        System.out.println(result[1]-result[0]+1);
    }
    public static int[] searchRange(int[] nums, int target) {
        int first=firstOccurrence(nums,target);
        int last=lastOccurrence(nums,target);
        return new int[]{first,last};
    }

    private static int lastOccurrence(int[] nums, int target) {

        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) {
                ans = mid;
                low = mid + 1;
            }else if(nums[mid]>target){
                high = mid - 1;
            }else{
                low=mid+1;
            }
        }
        return ans;
        //TC:O(log n)
        //SC:O(1)
    }

    private static int firstOccurrence(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) {
                ans = mid;
                high = mid - 1;
            }else if(nums[mid]>target){
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
