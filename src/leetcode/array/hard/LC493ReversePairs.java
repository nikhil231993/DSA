package leetcode.array.hard;

import java.util.ArrayList;
import java.util.List;

public class LC493ReversePairs {

    public static void main(String[] args) {
    int[] nums=new int[]{2,4,3,5,1};
        System.out.println(reversePairs(nums));
    }
    public static int reversePairs(int[] nums) {
        int n=nums.length;

        return mergeSort(nums, 0,  n-1);

    }

    private static int mergeSort(int[] nums, int low, int high) {

        int count=0;

        if(low>=high)
            return count;
        int mid=low+(high-low)/2;
        count+=mergeSort(nums,low,mid);
        count+=mergeSort(nums,mid+1,high);
        count+=reversePair(nums,low,mid,high);
        merge(nums,low,mid,high);
        return count;

    }

    private static void merge(int[] nums, int low, int mid, int high) {

        int left=low;
        int right=mid+1;
        List<Integer> result=new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]>=nums[right]){
                result.add(nums[right]);
                right++;
            }else{
                result.add(nums[left]);
                left++;
            }
        }

        while(left<=mid){
            result.add(nums[left]);
            left++;
        }
        while(right<=high){
            result.add(nums[right]);
            right++;
        }

        for(int i=low;i<=high;i++){
            nums[i]=result.get(i-low);
        }
    }

    private static int reversePair(int[] nums, int low, int mid, int high) {

        int right=mid+1;
        int pos=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && nums[i]>2* (long) nums[right])
                right++;
            pos+=right-(mid+1);
        }
        return pos;
        //TC:logn(n(merge)+n(count pairs))
    }
}
