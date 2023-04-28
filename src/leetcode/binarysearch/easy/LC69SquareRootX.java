package leetcode.binarysearch.easy;

public class LC69SquareRootX {

    public static void main(String[] args) {
        int x=2147395599;
        //INT mAX VALUE=2147483647
        System.out.println(sqrt(x));
    }

    private static int sqrt(int x) {
        int low=1;
        int high=x;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid==x/mid)
                return mid;
            else if(mid<x/mid){
               // ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
//        return ans;
        return low-1;
        //TC:o(log n)
        //sc:o(1)
        //Reason for dividing x by m is to avoid the overflow. If we want to use
        //normal binary search we can use with long variable
    }
}
