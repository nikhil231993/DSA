package leetcode.binarysearch.medium;

public class LC1760MinimumBallsInABag {

    public static void main(String[] args) {

        int[] nums =new int[] {2,4,8,2};
        int maxOperations = 4;
        System.out.println(minimumSize(nums,maxOperations));
    }

    public static int minimumSize(int[] nums, int maxOperations) {

        int low=1;//we want to reach this value which is the best
        //high can be any value even Integer.MA_VALUE can be used
        int high=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            high=Math.max(high, nums[i]);
        }

        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canSplit(mid, nums,maxOperations)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;

        //TC:O(nlogn)
        //sc:O(n)
    }

    public static boolean canSplit(int mid, int[] nums, int op){

        int operations=0;
        for(int i=0;i<nums.length;i++){
            operations+=(nums[i]-1)/mid;//mid is the desired weight. This is the formula to find operations
        }
        if(operations>op)
            return false;
        return true;
    }
}
