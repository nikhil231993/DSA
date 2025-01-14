package leetcode.binarysearch;

public class BS19SplitArrayLargestSumLC410 {

    public static void main(String[] args) {

        int[] num = new int[] {7,2,5,10,8};
        int k = 2;
        System.out.println(splitArray(num, k));
    }

    public static int splitArray(int[] nums, int k) {

        int n=nums.length, max=Integer.MIN_VALUE, sum=0;

        for(int i=0; i<n; i++){
            max=Math.max(max, nums[i]);
            sum+=nums[i];
        }

        int low=max, high=sum, ans=0;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(possible(mid, nums, k)){
                high=mid-1;
                ans=mid;
            }else
                low=mid+1;
        }
        return ans;
    }

    public static boolean possible(int mid, int[] a, int k) {

        int count = 1;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > mid) {
                count++;
                sum = a[i];
            }
        }
        if (count <= k)
            return true;
        return false;

        //TC:O(log (sum-max+1))* O(n)
        //SC:O(1)
    }
}
