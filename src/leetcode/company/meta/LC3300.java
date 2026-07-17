package leetcode.company.meta;

public class LC3300 {

    public static void main(String[] args) {
        int[] nums = new int[] {10,12,13,14};
        System.out.println(minElement(nums));
    }

    private static int minElement(int[] nums) {
        int n=nums.length, min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){

            int num=0;
            while(nums[i]>0){
                num+=nums[i]%10;
                nums[i]=nums[i]/10;
            }
            min=Math.min(num, min);
        }
        return min;
    }
}
