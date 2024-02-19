package leetcode.binarysearch.easy;

public class LC633SumOfSquares {

    public static void main(String[] args) {

        int c=18;
        System.out.println(judgeSquareSum(c));

        //This has a binary search solution will learn later
    }

    public static boolean judgeSquareSum(int c) {

        int left=0;
        long right=(long)Math.sqrt(c);
        while(left<=right){
            long value=left*left+ right*right;
            if(value == c){
                System.out.println(left);
                System.out.println(right);
                return true;
            }
            else if(value>c)
                right--;
            else
                left++;
        }
        return false;
    }
}
