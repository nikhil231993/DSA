package leetcode.company.meta;

public class LC713 {

    public static void main(String[] args) {
        int[] nums = new int[] {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;

        int left=0, right=0;
        int count=0;
        int product=1;

        while(right<n){
            product*=nums[right];

            while(product>=k){
                product=product/(nums[left]);
                left++;
            }

            if(product<k)
                count+=right-left+1;
            right++;
        }
        return count;
    }
}
