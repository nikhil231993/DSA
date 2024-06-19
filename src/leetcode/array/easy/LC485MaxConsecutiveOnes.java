package leetcode.array.easy;

public class LC485MaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] num=new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(num));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        int count=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)
                count++;
            else
                count=0;
            if(count>max)
                max=count;
        }
        return max;

        //SC:O(1)
        //TC:O(n)
    }
}
