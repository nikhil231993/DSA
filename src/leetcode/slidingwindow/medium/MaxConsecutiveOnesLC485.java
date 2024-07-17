package leetcode.slidingwindow.medium;

public class MaxConsecutiveOnesLC485 {

    public static void main(String[] args) {

        int[] nums=new int[]{1,1,0,1,1,1};
        System.out.println(maxConsecutiveOnes(nums));
    }

    private static int maxConsecutiveOnes(int[] nums) {

        int max=0, count=0;
        for(int i=0;i<nums.length;i++){

            if(nums[i]!=1)
                count=0;
            else
                count++;
            max=Math.max(count,max);
        }
        return max;

        //SC:O(1)
        //TC:O(n)
    }
}
