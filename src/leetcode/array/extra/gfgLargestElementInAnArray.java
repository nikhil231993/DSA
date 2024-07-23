package leetcode.array.extra;

public class gfgLargestElementInAnArray {

    //Q:https://practice.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-element-in-array

    public static void main(String[] args) {

        int[] arr=new int[]{1,8,7,56,90};
        int n=5;
        System.out.println(largest(arr,n));
    }

    public static int largest(int arr[], int n)
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }
    //TC:O(N)
    //SC:O(1)
}
