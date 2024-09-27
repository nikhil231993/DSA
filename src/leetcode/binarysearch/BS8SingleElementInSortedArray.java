package leetcode.binarysearch;

public class BS8SingleElementInSortedArray {

    public static void main(String[] args) {

        int[] arr=new int[]{1,1,2,3,3,4,4,8,8};

        //Approach 1: Using XOR
        System.out.println(xor(arr));

        //Approach 2: Using binary search
        System.out.println(singleNonDuplicate(arr));
    }

    private static int xor(int[] nums) {

        int ans=0;
         for(int i=0; i<nums.length; i++){
             ans = ans^nums[i];
         }
         return ans;

        //TC:O(n)
        //SC:O(1)
    }

    public static int singleNonDuplicate(int[] nums) {

        //Approach 2 using binary search
        int n=nums.length;
        if(n == 1)
            return nums[0];
        if(nums[0]!=nums[1])
            return nums[0];
        if(nums[n-1]!=nums[n-2])
            return nums[n-1];

        int low=1;
        int high=n-2;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
                return nums[mid];
            else if((mid%2==1 && nums[mid]==nums[mid-1]) || (mid%2==0 && nums[mid]==nums[mid+1])){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;

        //TC:O(log n)
        //SC:O(1)
    }
}
