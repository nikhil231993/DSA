package leetcode.binarysearch;

public class BS23RowsWithMaxOnesLC2643 {

    public static void main(String[] args) {

        int[][] arr=new int[][]{{0,1,1},{0,1,1}};
        int n=2,m=3;

        //Approach 1
        System.out.println(findInMatrix(arr,n,m));

        //Approach 2
        System.out.println(rowWithMax1s(arr,n,m));
    }

    private static int findInMatrix(int[][] arr, int n, int m) {

        int maxCount=Integer.MIN_VALUE;
        int rowIndex=-1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    count++;
                }
            }
            if(count>maxCount){
                maxCount=count;
                rowIndex=i;
            }
        }
        return rowIndex;

        //TC:O(n*m)
        //SC:O(1)
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

    public static int findSmallestOneIndex(int[] num, int m, int target){

        int low=0;
        int high=m-1;
        int ans=m;
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
