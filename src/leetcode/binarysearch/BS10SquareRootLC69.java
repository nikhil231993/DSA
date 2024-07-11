package leetcode.binarysearch;

public class BS10SquareRootLC69 {

    public static void main(String[] args) {

        int x=28;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {

        int low=1, high=x, ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(x/mid<mid){
                high=mid-1;
            }else{
                ans=mid;
                low=mid+1;
            }
        }
        return ans;

        //TC:O(log n)
        //SC:O(1)

        //Reason for dividing x by m is to avoid the overflow. If we want to use
        //normal binary search we can use with long variable
    }
}
