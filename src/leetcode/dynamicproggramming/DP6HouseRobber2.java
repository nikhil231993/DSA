package leetcode.dynamicproggramming;
public class DP6HouseRobber2 {

    public static void main(String[] args) {
        int[] nums =new int[] {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        int[] numsExceptFirst=new int[n];
        int[] numsExceptLast=new int[n];

        for(int i=0;i<n;i++){
            if(i!=0)
                numsExceptFirst[i]=nums[i];
            if(i!=n-1)
                numsExceptLast[i]=nums[i];
        }
        return Math.max(space(numsExceptLast, n),space(numsExceptFirst,n));
    }

    private static int space(int[] nums, int n) {
        int prev=nums[0];
        int prev2=0;//palceholder
        for(int i=1;i<n;i++){
            int pick=nums[i];
            if(i>1)
                pick+=prev2;
            int notpick=0+prev;

            int curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}
