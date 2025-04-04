package leetcode.heap.easy;

public class LC2016MaximumDifference {

    public static void main(String[] args) {

        int[] nums = new int[] {7,1,5,4};

        //Approach 1
        System.out.println(maximumDifference(nums));

        //Approach 2
        System.out.println(maximumDifferenceOptimized(nums));
    }

    public static int maximumDifference(int[] nums) {

        Integer maxDiff=-1;
        for(int i=0; i<nums.length-1; i++){

            for(int j=i+1;j<nums.length;j++){

                if(nums[j] > nums[i] && nums[j]-nums[i] > maxDiff){
                    maxDiff=nums[j]-nums[i];
                }
            }
        }
        return maxDiff;

        //TC:O(n*n)
        //SC:O(1
    }

    public static int maximumDifferenceOptimized(int[] nums) {

        int maxDiff=-1, min=Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){
            if (min > nums[i])
                min = nums[i];
            if(nums[i]!=min)
                maxDiff = Math.max(nums[i] - min, maxDiff);
        }
        return maxDiff;

        //TC:O(n)
        //SC:O(1)
    }
}
