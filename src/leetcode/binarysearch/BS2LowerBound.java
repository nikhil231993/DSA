package leetcode.binarysearch;

public class BS2LowerBound {

    //Note: Smallest index/number which is greater than or equal to

    public static void main(String[] args) {

        int[] arr=new int[]{3,5,8,15,19,19};
        int x=19;
        System.out.println(lowerBound(arr,x));
    }

    private static int lowerBound(int[] arr, int x) {

        int low=0;
        int ans=arr.length;     //Return last hypothetical answer
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
    }
}
