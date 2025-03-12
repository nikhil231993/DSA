package leetcode.twopointer.medium;

public class LC75SortColors {

    public static void main(String[] args) {

        int[] num=new int[]{2,0,2,1,1,0};

        //Approach 1:
        sortColors(num);
        for(int n:num)
            System.out.println(n);
    }

    public static void sortColors(int[] nums) {

        int low=0, mid=0, high=nums.length-1;

        while(mid<=high){
            if(nums[mid]==0){
                swap(low,mid,nums);
                low++;
                mid++;
            }else if(nums[mid]==1)
                mid++;
            else{
                swap(mid,high,nums);
                high--;
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
