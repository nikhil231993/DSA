package leetcode.binarysearch.easy;

public class LC1608SpecialArray {

    public static void main(String[] args) {

        int[] nums =new int[] {3,5};
        System.out.println(specialArray(nums));
    }

    public static int specialArray(int[] nums) {

        int low=0;
        int high=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            high=Math.max(high, nums[i]);
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int count=find(mid, nums);
            if(count==mid){
                return mid;
            }else if(count<mid){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;

    }

    public static int find(int mid, int[] nums){

        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= mid)
                count++;
        }
        return count;
    }
}
