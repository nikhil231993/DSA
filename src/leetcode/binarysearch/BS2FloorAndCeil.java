package leetcode.binarysearch;

public class BS2FloorAndCeil {

    public static void main(String[] args) {
        int[] arr=new int[]{10,20,30,40,50};
        int x=30;

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

    }

    private static int ceil(int[] arr, int x) {
        int n=arr.length;

        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid]>=x)
            {
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
       if(ans==-1)
           return -1;
       else return arr[ans];

    }


}
