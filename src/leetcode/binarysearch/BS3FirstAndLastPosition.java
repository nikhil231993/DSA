package leetcode.binarysearch;

public class BS3FirstAndLastPosition {

    public static void main(String[] args) {
        int[] num =new int[]{5,7,7,8,8,10};
        int target=8;

        int[] result=searchRange(num,target);

        for(int n:result)
            System.out.println(n);
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
            }
            else if(nums[mid]<target){

                low = mid + 1;
            }else{
                high=mid-1;
            }
        }
        return ans;
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
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
