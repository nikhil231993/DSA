package leetcode.array.easy;

public class LC1929ConcatenationArray {

    public static void main(String[] args) {

        int[] nums=new int[]{1,2,1};

        //Approach 1: Using Two Loops
        int[] result=getConcatenation(nums);
        for(int n:result)
            System.out.println(n);

        System.out.println("##########");

        //Approach 2: Single parse but no improvement in TC
        int[] result1=getConcatenationSingleParse(nums);
        for(int n:result1)
            System.out.println(n);
    }

    public static int[] getConcatenationSingleParse(int[] nums) {

        int n=nums.length;
        int[] arr=new int[2*n];

        for(int i=0; i<nums.length; i++){
            arr[i]=nums[i];
            arr[n+i]=nums[i];
        }
        return arr;
    }

    public static int[] getConcatenation(int[] nums) {

        int[] ans=new int[2*nums.length];
        int j=0;
        for(int k=0;k<2;k++){
            for(int i=0;i<nums.length;i++){
                ans[j++]=nums[i];
            }
        }
        return ans;

        //TC:O(2*n)
        //SC:O(2n) for ans
    }
}
