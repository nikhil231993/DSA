package leetcode.binarysearch;

public class BS2InsertPositionLC35 {

    public static void main(String[] args) {

        int[] arr=new int[]{1,2,4,7};
        int x=0;
        System.out.println(insertPosition(arr,x));
    }

    private static int insertPosition(int[] arr, int x) {

        int low=0;
        int ans=arr.length;//Return last hypothetical answer
        int high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;
                high=mid-1;
            }
            else 
            	low=mid+1;
        }
        return ans;

        //TC:O(log n)
        //SC:O(1)
        //Same as lower bound problem
    }
}
