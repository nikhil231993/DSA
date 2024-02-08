package leetcode.sortingtechniques;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr=new int[]{100,3,4,2,5,6,29,47,100,201};
        mergeSort(arr);
        display(arr);

        //TC:O(Nlog N)
        //SC:O(N) extra space
    }

    private static void display(int[] arr) {

        for(Integer n: arr)
            System.out.println(n);
    }

    private static void mergeSort(int[] arr) {
        int n=arr.length;
        mergeSorting(arr, 0, n-1);
    }

    private static void mergeSorting(int[] arr, int low, int high) {
        if(low==high)
            return;
        int mid=low+(high-low)/2;
        mergeSorting(arr, low, mid);
        mergeSorting(arr,mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        List<Integer> list=new ArrayList<>();
        int first=low;
        int second=mid+1;

        while(first<=mid && second<= high){
            if(arr[first]<=arr[second]){
                list.add(arr[first]);
                first++;
            }else{
                list.add(arr[second]);
                second++;
            }
        }

        while(first<=mid){
            list.add(arr[first]);
            first++;
        }

        while(second<=high){
            list.add(arr[second]);
            second++;
        }

        for(int i=low;i<=high;i++){
            arr[i]=list.get(i-low);
        }
    }
}
