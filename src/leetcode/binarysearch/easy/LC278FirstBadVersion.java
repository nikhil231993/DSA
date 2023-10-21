package leetcode.binarysearch.easy;

public class LC278FirstBadVersion {

    public static void main(String[] args) {
        int n = 5, bad = 4;
        System.out.println(firstBadVersion(n));
    }
    public static int firstBadVersion(int n) {
        int low=1;
        int high=n;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isBadVersion(mid)){
                ans=mid;
                high=mid-1;
            }else
                low=mid+1;
        }
        return ans;
    }

    private static boolean isBadVersion(int mid) {
        if(mid==3)
            return false;
        else if(mid==4)
            return true;
        else if(mid==5)
            return true;
        return false;
    }
}
