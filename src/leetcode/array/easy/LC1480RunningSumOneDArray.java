package leetcode.array.easy;

public class LC1480RunningSumOneDArray {

    public static void main(String[] args) {

        int[] nums =new int[] {1,2,3,4,5};

        //Approach 1 Brute
        int[] r=runningSumBrute(nums);
        for(int n:r)
            System.out.println(n);

        System.out.println("############");

        //Approach 2 Optimal
        runningSum(nums);
        for(int num:nums)
            System.out.println(num);
    }

    private static int[] runningSumBrute(int[] nums) {

        int[] result=new int[nums.length];
        result[0]=nums[0];
        for(int i=1;i<result.length;i++){
            result[i]+=nums[i]+result[i-1];
        }
        return result;

        //SC:O(n)
        //TC:O(n)
    }

    public static void runningSum(int[] nums) {

        for (int i=1;i<nums.length;i++){
            nums[i]+=nums[i-1];
        }

        //SC:O(1)
        //TC:O(n)
    }
}
