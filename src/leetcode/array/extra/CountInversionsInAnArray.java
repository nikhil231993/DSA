package leetcode.array.extra;

import java.util.ArrayList;
import java.util.List;

public class CountInversionsInAnArray {

    public static void main(String[] args) {
        int[] arr=new int[]{5, 3, 2, 4, 1};
        System.out.println(countInversions(arr));
    }

    private static int countInversions(int[] arr) {
        return mergeSort(arr,0,arr.length-1);
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int count=0;
        if(low>=high)
            return count;
        int mid=low+(high-low)/2;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
    }

    private static int merge(int[] arr, int low, int mid, int high) {

        List<Integer> result=new ArrayList<>();
        int left=low;
        int right=mid+1;
        int count=0;
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                result.add(arr[left]);
                left++;
            }else{
                result.add(arr[right]);
                right++;
                count+=mid-left+1;
            }
        }

        while(left<=mid){
            result.add(arr[left]);
            left++;
        }

        while(right<=high){
            result.add(arr[right]);
            right++;
        }

        for(int i=low;i<=high;i++){
            arr[i]=result.get(i-low);
        }
        return count;
    }
    //TC:O(logn)
    //SC:O(n)
}
