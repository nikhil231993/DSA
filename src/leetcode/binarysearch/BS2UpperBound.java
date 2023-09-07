package leetcode.binarysearch;

public class BS2UpperBound {

    public static void main(String[] args) {

        int[] arr=new int[]{3,5,8,9,15,19};
        int x=9;

        System.out.println(upperBound(arr,x));
    }

    private static int upperBound(int[] arr, int x) {

        int n=arr.length;
        int low=0;
        int high=n-1;

        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>x){
              ans=mid;
              high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
        //TC:O(log n)
        //SC:O(1)
    }
}
