package leetcode.array.easy;

public class LC1929ConcatenationArray {

    public static void main(String[] args) {
        int[] nums=new int[]{1,2,1};
        int[] result=getConcatenation(nums);
        for(int n:result)
            System.out.println(n);
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

    }
}
