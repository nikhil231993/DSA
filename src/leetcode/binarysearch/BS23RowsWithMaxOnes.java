package leetcode.binarysearch;

public class BS23RowsWithMaxOnes {

    public static void main(String[] args) {
        int[][] arr=new int[][]{{0,0},{0,1},{0,0},{0,0},{0,1},{0,1}};
        int n=6,m=2;
        System.out.println(rowWithMax1s(arr,n,m));
    }

   public static int rowWithMax1s(int arr[][], int n, int m) {
        int maxValue=0;
        int index=-1;
        for(int i=0;i<n;i++){
            int count=m-findSmallestOneIndex(arr[i], m, 1);
            if(count>maxValue){
                maxValue=count;
                index=i;
            }
        }
        return index;
    }

    public static int findSmallestOneIndex(int[] num, int n , int target){
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(num[mid]>=target){
                ans=mid;
                high=mid-1;
            }else
                low=mid+1;
        }
        return ans;
        //TC:O(n log m)
        //SC:O(1)
    }
}
