package leetcode.slidingwindowandtwopointer.medium;

public class MaxConsecutiveOnes2LC485Premium {
    //Question: we can flip atmost one 0 to one. So find the max length;
    public static void main(String[] args) {
        int[] nums=new int[]{1,0,1,1,1,0,1,1};
        int k=1;

        System.out.println(max(nums,k));
    }

    private static int max(int[] nums,int k) {

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
        //sc:O(N)
    }
}
