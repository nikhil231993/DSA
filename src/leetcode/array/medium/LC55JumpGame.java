package leetcode.array.medium;

public class LC55JumpGame {

    public static void main(String[] args) {

        int[] nums =new int[] {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {

        int n=nums.length;
        int goal=n-1;

        for(int i=n-1; i>=0; i--){
            if(nums[i]+i>=goal)
                goal=i;
        }

        return goal==0;

        //TC:O(n)
        //SC:O(1)
    }
}
