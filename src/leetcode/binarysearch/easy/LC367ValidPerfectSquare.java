package leetcode.binarysearch.easy;

public class LC367ValidPerfectSquare {

    public static void main(String[] args) {

        int num=5;
        System.out.println(isPerfectSquare(num));
        //for value 5 num/mid==mid that's why we use double to avoid decimal scenarios
    }

    public static boolean isPerfectSquare(int num) {

        if(num==1)
            return true;

        int low=0, high=num/2;

        while(low<=high){
            int mid=low+(high-low)/2;
            if((double)num/mid==mid)
                return true;
            else if(num/mid<mid)
                high=mid-1;
            else
                low=mid+1;
        }
        return false;
    }
}
