package leetcode.heap.easy;

public class LC2239FindClosestNumberToZero {

    public static void main(String[] args) {
       int[] nums =new int[] {-4,-2,1,4,8};
        System.out.println(findClosestNumber(nums));

    }
    public static int findClosestNumber(int[] nums) {
        Integer min=Integer.MAX_VALUE;

        int n=Integer.MIN_VALUE;;
        for(int num:nums)
            if(Math.abs(num-0)<min){
                min=Math.abs(num-0);
                n=num;
            }else if(Math.abs(num-0)==min && num>n){
                min=Math.abs(num-0);
                n=num;
            }
        return n;
        //TC:O(n)
        //SC:O(1)
    }
}
