package leetcode.binarysearch.easy;

public class LC374GuessHigherOrLower {

    private static int pick=1;
    public static void main(String[] args) {
        int n=2;
        System.out.println(guessNumber(n));
    }

    public static int guessNumber(int n) {
        int low=0;
        int high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            int val=guess(mid);
            if(val==0)
                return mid;
            else if(val==-1)
                high=mid-1;
            else
                low=mid+1;
        }
        return 0;
        //TC:O(log n)
        //SC:O(1
    }

    private static int guess(int mid) {
        if(mid>pick)
            return -1;
        else if(mid<pick)
            return 1;
        return 0;
    }
}
