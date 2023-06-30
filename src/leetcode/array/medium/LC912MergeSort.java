package leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

public class LC912MeregSort {

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,2,0,0};
        int[] result=sortArray(nums);
        for(int n: result)
            System.out.println(n);
    }

    public static int[] sortArray(int[] nums) {

         mergeSort(nums,0,nums.length-1);
         return nums;
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if(low>=high)
            return;
        int mid=low+(high-low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
        //TC:O(nlogn) 2 *Log n for mergeSort func + n for merge function
        //SC:O(n) temp array
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        List<Integer> temp=new ArrayList<>();
        int left=low;
        int right=mid+1;

        while(left<=mid && right<=high){

            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(nums[left]);
            left++;
        }
        while(right<=high){
            temp.add(nums[right]);
            right++;
        }

        for(int i=low;i<=high;i++){
            nums[i]=temp.get(i-low);
        }
    }
}
