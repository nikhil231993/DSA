package leetcode.TwoPointer.medium;

public class LC75SortColors {

    public static void main(String[] args) {
        int[] num=new int[]{2,0,2,1,1,0};
        sortColors(num);
        for(int n:num)
            System.out.println(n);
    }
    public static void sortColors(int[] nums) {

        int start=0;
        int mid=0;
        int last=nums.length-1;

        while(mid<=last){
            if(nums[mid]==0){
                swap(start,mid,nums);
                start++;
                mid++;
            }else if(nums[mid]==1)
                mid++;
            else{
                swap(mid,last,nums);
                last--;
            }
        }
        //TC:O(n)
        //SC:O(1)
    }

    public static void swap(int i, int j, int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
