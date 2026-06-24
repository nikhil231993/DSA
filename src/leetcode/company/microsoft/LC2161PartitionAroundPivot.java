package leetcode.company.microsoft;

public class LC2161PartitionAroundPivot {

    public static void main(String[] args) {

        int[] nums = new int[] {9,12,5,10,14,3,10};
        int pivot = 10;
        int [] result=pivotArray(nums, pivot);
        for(int num:result)
            System.out.println(num);
    }

    private static int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int lessI = 0;
        int greaterI = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                ans[lessI] = nums[i];
                lessI++;
            }
            if (nums[j] > pivot) {
                ans[greaterI] = nums[j];
                greaterI--;
            }
        }
        while (lessI <= greaterI) {
            ans[lessI] = pivot;
            lessI++;
        }
        return ans;
    }
}
