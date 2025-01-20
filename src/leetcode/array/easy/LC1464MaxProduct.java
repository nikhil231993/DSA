package leetcode.array.easy;

public class LC1464MaxProduct {

    public static void main(String[] args) {

        int[] nums =new int[] {3,4,5,2};

        //Approach 1: User two for loops TC:O(n square)

        //Approach 2: Sort and use last two values from TC:O(nlogn) due to sorting

        //Approach 3: Optimal
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {

        int max=Integer.MIN_VALUE, secMax=Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            if(nums[i] >= max){
                secMax=max;
                max=nums[i];
            }else if(nums[i]<max && nums[i]>secMax){
                secMax=nums[i];
            }
        }
        return (secMax-1)*(max-1);

        //TC:O(n)
        //SC:O(1)
    }
}
