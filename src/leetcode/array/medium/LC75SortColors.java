package leetcode.array.medium;

public class LC75SortColors {

    public static void main(String[] args) {

        int[] nums =new int[] {2,0,2,1,1,0};

        //Approach 1: Sort it TC:O(nlogn)

        //Approach 2: Have 3 variables along with count of 0, 1, 2 and then form an array using it. Here we need two iterations

        //Approach 3: Optimal
        sort(nums);
        System.out.println("Sorted numbers are: ");
        for(int n: nums)
            System.out.println(n);
    }

    //Dutch National Flag Algo
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
            //SC:O(1)
        }
    }

    public static void swap(int num1,int num2,int[] nums){
        int temp=nums[num1];
        nums[num1]=nums[num2];
        nums[num2]=temp;
    }
}
