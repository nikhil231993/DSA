package leetcode.array.easy;

public class LC2778SquaresSpecialElement {

    public static void main(String[] args) {

        //Index is the only issue as the array starts with 1 index
       int[] nums =new int[] {2,7,1,19,18,3};
       System.out.println(sumOfSquares(nums));

       System.out.println(sumOfSquaresAlternative(nums));
    }

    private static int sumOfSquares(int[] nums) {

        int n=nums.length, sum=0;
        for(int i=1; i<=nums.length; i++){
            if(n%i==0)
                sum+=nums[i-1] * nums[i-1];
        }
        return sum;

        //TC:O(n)
        //SC:O(1)
    }

    private static int sumOfSquaresAlternative(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(n%(i+1)==0)
                sum+=(nums[i]*nums[i]);
        }
        return sum;
    }
}
