package leetcode.company.microsoft;

public class LC643MaximumAverageSubarray {

    public static void main(String[] args) {

        int[] nums =new int[] {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
        System.out.println(findMaxAverageRefined(nums, k));
    }

    private static double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int left=0, right=0, count=0;
        double sum=0.0, average=0.0, maxAverage=Integer.MIN_VALUE;;
        while(right<n){
            sum+=nums[right];
            count++;
            if(count==k){
                average=sum/(double)k;
                maxAverage=Math.max(maxAverage, average);
                count--;
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return maxAverage;
    }

    private static double findMaxAverageRefined(int[] nums, int k) {
        double sum = 0, n = nums.length;
        double max = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while (right < n) {
            sum = sum + nums[right];
            if (right - left + 1 > k) {
                sum = sum - nums[left];
                left++;
            }
            if (right - left + 1 == k) {
                max = Math.max(max, sum/k);
            }
            right++;
        }
        return max;
    }
}
