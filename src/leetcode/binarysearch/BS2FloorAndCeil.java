package leetcode.binarysearch;

public class BS2FloorAndCeil {

    public static void main(String[] args) {

        int[] arr=new int[]{2,4,6,8,8,8,11,13};
        int x=10;
        System.out.println("Ceil index is: " +ceil(arr,x));
        System.out.println("floor index is: " +floorMethod(arr,x));
    }

    private static int floorMethod(int[] arr, int x) {

        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=x){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
            if(ans==-1)
                return -1;
            else return arr[ans];

        //TC:O(log n)
        //SC:O(1)
    }

    private static int ceil(int[] arr, int x) {

        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x) {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
       if(ans==-1)
           return -1;
       else return arr[ans];

        //TC:O(log n)
        //SC:O(1)
        //Same as lower bound problem
    }
}
