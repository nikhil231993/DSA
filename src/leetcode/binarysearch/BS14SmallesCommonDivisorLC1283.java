package leetcode.binarysearch;

public class BS14SmallesCommonDivisorLC1283 {

    public static void main(String[] args) {
       int[] nums =new int[] {1,2,5,9};
       int threshold = 6;
        System.out.println(smallestDivisor(nums,threshold));

        //TC:O(log max-1+1)* n
        //SC: O(1)
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        int low=1;
        int high=max;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(minValue(nums, mid, threshold)){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }

    public static boolean minValue(int[] nums, int mid, int threshold ){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double) nums[i]/mid);
        }
        return sum<=threshold;
    }
}
