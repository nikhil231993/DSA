package leetcode.binarysearch;

public class BS2FloorAndCeil {

    public static void main(String[] args) {

        int[] arr=new int[]{2,4,6,8,8,8,11,13};
        arr=new int[]{3, 4, 7, 8, 8, 10};
        int x=8;
        x=5;
        System.out.println("Ceil number is: " + ceil(arr,x));
        System.out.println("floor number is: " + floorMethod(arr,x));
    }

    private static int floorMethod(int[] arr, int x) {

    	//largest number which <= x
        int n=arr.length;
        int low=0, high=n-1, ans=-1;

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
        else
            return ans;

        // TC:O(log n)
        // SC:O(1)
    }

    private static int ceil(int[] arr, int x) {

    	//smallest number which is >=x which is equal to lower bound
        int n=arr.length;
        int low=0, high=n-1, ans=-1;

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
       else 
    	   return ans;

        //TC:O(log n)
        //SC:O(1)
        // Same as lower bound problem
    }
}
