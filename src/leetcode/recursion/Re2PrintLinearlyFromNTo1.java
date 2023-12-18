package leetcode.recursion;

public class Re2PrintLinearlyFromNTo1 {

    public static void main(String[] args) {

        recursionReverse(5,5);
        System.out.println("############");
        recursionByBackTracking(1,5);
    }

    private static void recursionByBackTracking(int i, int n) {

        if(i>n)
            return;
        recursionByBackTracking(i+1,n);
        System.out.println(i);
        //TC:O(N)
        //SC:O(N)
    }

    private static void recursionReverse(int i, int n) {

        if(i==0)
            return;
        System.out.println(i);
        recursionReverse(i-1,n);
        //TC:O(N)
        //SC:O(N)
    }
}
