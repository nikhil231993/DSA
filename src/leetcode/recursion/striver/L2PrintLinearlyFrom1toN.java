package leetcode.recursion.striver;

public class L2PrintLinearlyFrom1toN {

    public static void main(String[] args) {

        recursion(1,5);
        System.out.println("##########");
        recursionBackTracking(5,5);
    }

    private static void recursion(int i, int n) {

        if(i>n)
            return;
        System.out.println(i++);
        recursion(i,n);

        //TC:O(N)
        //SC:O(N)
    }

    private static void recursionBackTracking(int i,int n){

        if(i<1)
            return;
        recursionBackTracking(i-1,n);
        System.out.println(i);

        //TC:O(N)
        //SC:O(N)
    }
}
