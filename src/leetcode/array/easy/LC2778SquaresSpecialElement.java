package leetcode.array.easy;

public class LC2778SquaresSpecialElement {

    public static void main(String[] args) {

        //Index is the only issue as the array starts with 1 index
       int[] nums =new int[] {2,7,1,19,18,3};
       System.out.println(sumOfSquares(nums));
    }

    public static int sumOfSquares(int[] nums) {

        int n=nums.length;
        int sum=0;
        for(int i=1;i<=nums.length;i++){
            if(n%i==0)
                sum+=nums[i-1]*nums[i-1];
        }
        return sum;

        //TC:O(n)
        //SC:O(1)
    }
}
