package leetcode.slidingwindow.medium;

public class MaxConsecutiveOnes2LC485Premium {

    //Question: we can flip atmost one 0 to one. So find the max length;

    public static void main(String[] args) {

        int[] nums=new int[]{1,0,1,1,1,0,1,1};
        int k=1;

        //Approach 1: Brute
        System.out.println(brute(nums, k));

        //Approach 2: Better
        System.out.println(better(nums,k));

        //Approach 2: Best
        System.out.println(best(nums,k));
    }

    private static int better(int[] nums, int k) {

        int right=0, left=0, n=nums.length, maxLen=-1, count=0;

        while(right<n){
            if(nums[right]==0)
                count++;
            while(count>k){
                if(nums[left]==0)
                    count--;
                left++;
            }
            if(count<=k)
                maxLen=Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;

        //TC:O(N+N)
        //SC:O(1)
    }

    private static int brute(int[] nums, int k) {

        int n=nums.length;
        Integer maxLen=Integer.MIN_VALUE;

        for(int i=0; i<n; i++){

            int count=0;
            for(int j=i; j<n ;j++){
                if(nums[j]==0)
                    count++;
                if(count<=k)
                    maxLen=Math.max(maxLen, j-i+1);
                else
                    break;
            }
        }
        return maxLen;

        //TC:O(n square)
        //SC:O(1)
    }

    private static int best(int[] nums,int k) {

        int left=0;
        int len=0;
        int zeroCount=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zeroCount++;

            while(zeroCount>k){
                if(nums[left]==0)
                    zeroCount--;
                left++;
            }
            len=Math.max(i-left+1,len);
        }
        return len;

        //TC:O(N)
        //SC:O(1)
    }
}
