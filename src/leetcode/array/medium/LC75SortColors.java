package leetcode.array.medium;

public class LC75SortColors {

    public static void main(String[] args) {
        int[] nums =new int[] {2,0,2,1,1,0};
        sort(nums);
        System.out.println("Sorted numbers are: ");
        for(int n: nums)
            System.out.println(n);
    }

    //Dutch National Flag ALgo
    private static void sort(int[] nums) {

        int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(low,mid,nums);
                low++;
                mid++;
            }else if(nums[mid]==1){
                mid++;
            }else if(nums[mid]==2){
                swap(mid,high,nums);
                high--;
            }
            //TC:O(n)
        }
    }

    public static void swap(int num1,int num2,int[] nums){
        int temp=nums[num1];
        nums[num1]=nums[num2];
        nums[num2]=temp;
    }
}
