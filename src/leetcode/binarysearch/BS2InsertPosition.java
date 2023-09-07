package leetcode.binarysearch;

public class BS2InsertPosition {

    public static void main(String[] args) {

        int[] arr=new int[]{1,3,5,6};
        int x=7;

        System.out.println(insertPosition(arr,x));
    }

    private static int insertPosition(int[] arr, int x) {
        if(arr[0]>x)
            return 0;

        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]==x)
                return mid;
            else if(arr[mid]>x){
                high=mid-1;
            }else{
                ans=mid;
                low=mid+1;
            }
        }
        return ans+1;
        //TC:O(log n)
        //SC:O(1)
    }
}
