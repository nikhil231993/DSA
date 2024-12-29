package leetcode.dynamicprogramming;

import java.util.Arrays;

public class DP6LC213HouseRobber2 {

    public static void main(String[] args) {

        int[] nums =new int[] {1,2,3,1};

        //Recursion
        System.out.println(recursionHouse(nums, nums.length));

        //Memoization
        System.out.println(memoizationHouse(nums, nums.length));

        //Memoization
        System.out.println(tabulationHouse(nums, nums.length));

        //Space
        System.out.println(rob(nums));
    }

    public static int tabulationHouse(int[] nums, int n) {

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
        int[] dp1=new int[n+1];
        Arrays.fill(dp1,-1);

        int[] dp2=new int[n+1];
        Arrays.fill(dp2,-1);
        return Math.max(tabulation(numsExceptLast, n-1, dp1), tabulation(numsExceptFirst,n-1, dp2));
    }

    public static int tabulation(int[] nums, int n, int[] dp){

        dp[0]=nums[0];
        for(int i=1;i<=n;i++){
            int notpick=nums[i];
            if(i>1)
                notpick+=dp[i-2];
            int pick=0+dp[i-1];
            dp[i]=Math.max(notpick, pick);
        }
        return dp[n];
    }

    public static int memoizationHouse(int[] nums, int n) {

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
        int[] dp1=new int[n+1];
        Arrays.fill(dp1,-1);

        int[] dp2=new int[n+1];
        Arrays.fill(dp2,-1);
        return Math.max(memoizationHouse(numsExceptLast, n-1, dp1), memoizationHouse(numsExceptFirst,n-1, dp2));
    }

    public static int memoizationHouse(int[] nums, int n, int[] dp){

        if(n==0) return nums[0];
        int notpick=nums[n];
        if(dp[n]!=-1) return dp[n];
        if(n>1)
            notpick+=memoizationHouse(nums, n-2, dp);
        int pick=0+memoizationHouse(nums, n-1, dp);
        return dp[n]=Math.max(pick, notpick);
    }

    public static int recursionHouse(int[] nums, int n) {

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
        return Math.max(recursion(numsExceptLast, n-1), recursion(numsExceptFirst,n-1));
    }

    public static int recursion(int[] nums, int n){

        if(n==0) return nums[0];
        if(n<0) return 0;
        int notpick=nums[n]+recursion(nums, n-2);
        int pick=0+recursion(nums, n-1);
        return Math.max(pick, notpick);
    }


    public static int rob(int[] nums) {

        int n=nums.length;
        if(n==1)
            return nums[0];
        int[] arrayExceptFirst=new int[n];
        int[] arrayExceptLast=new int[n];

        for(int i=0;i<n;i++){
            if(i!=0)
                arrayExceptFirst[i]=nums[i];
            if(i!=n-1)
                arrayExceptLast[i]=nums[i];
        }
        return Math.max(space(arrayExceptLast, n), space(arrayExceptFirst,n));
    }

    private static int space(int[] nums, int n) {

        int prev=nums[0];
        int prev2=0;        //placeholder

        for(int i=1;i<n;i++){ //if we pass n=n-1 in calling function then it is i<=n
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
