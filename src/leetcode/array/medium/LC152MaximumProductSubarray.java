package leetcode.array.medium;

public class LC152MaximumProductSubarray {

    public static void main(String[] args) {
        int[] num=new int[]{2,3,-2,4};
        System.out.println(maxProduct(num));
        //TC:O(N)
        //SC:O(1)
    }

    public static int maxProduct(int[] nums) {
        int n=nums.length;
        int prefix=1;
        int suffix=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix==0)
                prefix=1;
            if(suffix==0)
                suffix=1;
            prefix=prefix*nums[i];
            suffix=suffix*nums[n-i-1];
            max=Math.max(max,Math.max(prefix,suffix));
        }
        return max;
    }
}
