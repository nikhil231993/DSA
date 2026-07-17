package leetcode.company.meta;

public class LC1295 {

    public static void main(String[] args) {
        int[] nums = new int[] {12,345,2,6,7896};
        System.out.println(findNumbers(nums));
    }

    private static int findNumbers(int[] nums) {
        int count=0;
        int n=nums.length;

        for(int i=0;i<n;i++){
            int num=0;
            while(nums[i]>0){
                num++;
                nums[i]=nums[i]/10;
            }
            if(num%2==0) count++;
        }
        return count;
    }
}
