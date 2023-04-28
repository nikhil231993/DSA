package leetcode.binarysearch.medium;

public class LC34FirstAndLastPosition {

    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,10};
        int target=8;
        int firstPos=firstPosition(nums,target);
        int lastPos=lastPosition(nums,target);
        System.out.println("positions are: "+ firstPos+" "+lastPos);
    }

    private static int firstPosition(int[] nums,int target) {

        int low=0;
        int high=nums.length-1;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                high=mid-1;
            }else if(nums[mid]< target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    private static int lastPosition(int[] nums,int target) {

        int low=0;
        int high=nums.length-1;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }else if(nums[mid]< target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
