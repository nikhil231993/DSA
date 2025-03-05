package leetcode.sortingtechniques;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr=new int[]{100,3,4,2,5,6,29,47,100,201};
        int n=arr.length;
        mergeSort(arr, 0, n-1);

        for(int num : arr)
            System.out.println(num);

        //TC:O(Nlog N)
        //SC:O(N) extra space
    }

    public static void mergeSort(int[] arr, int low, int high){

        if(low>=high)
            return;
        int mid=low+(high-low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr , low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high){

        int left=low;
        int right=mid+1;
        List<Integer> ans=new ArrayList<>();

        while(left<=mid && right<=high){

            if(arr[left]<=arr[right]){
                ans.add(arr[left]);
                left++;
            }else{
                ans.add(arr[right]);
                right++;
            }
        }

        while(left<=mid){
            ans.add(arr[left]);
            left++;
        }

        while(right<=high){
            ans.add(arr[right]);
            right++;
        }

        for(int i=low; i<=high; i++){
            arr[i]=ans.get(i-low);
        }
    }
}
