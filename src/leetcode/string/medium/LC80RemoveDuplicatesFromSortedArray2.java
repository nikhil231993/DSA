package leetcode.string.medium;

public class LC80RemoveDuplicatesFromSortedArray2 {

    public static void main(String[] args) {

        int[] nums=new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {

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
}
