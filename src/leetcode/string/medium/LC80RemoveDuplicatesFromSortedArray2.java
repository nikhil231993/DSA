package leetcode.string.medium;

public class LC80RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {

        int[] nums=new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));

        //optimized
        System.out.println(removeDuplicatesOptimized(nums));
    }

    private static int removeDuplicates(int[] nums) {

        int count=1;
        int i=0;
        int n=nums.length;
        int [] result=new int[n];
        result[i++]=nums[0];
        for(int j=1; j<n; j++){
            if(nums[j]==nums[j-1])
                count++;
            if(nums[j-1]!=nums[j]){
                count=1;
            }
            if(count<=2)
                nums[i++]=nums[j];
        }
        return i;
    }

    private static int removeDuplicatesOptimized(int[] nums) {
        int n=nums.length;
        int i=2;
        for(int j=2;j<n;j++){
            if(nums[i-2]!=nums[j]){
                nums[i++]=nums[j];
            }
        }
        return i;
        //TC:O(n)
        //SC:O(1)
    }
}
