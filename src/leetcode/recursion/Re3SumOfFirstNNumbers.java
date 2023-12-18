package leetcode.recursion;

public class Re3SumOfFirstNNumbers {

    public static void main(String[] args) {

        int n=10;
        sumParameterized(1,0,10);
        int s=sumFunctional(1,n);
        System.out.println(s);
    }

    private static void sumParameterized(int i, int s,int n) {

        if(i>10) {
            System.out.println(s);
            return;
        }
        sumParameterized(i+1,s+i,n);
        //TC:O(N)
        //SC:O(N)
    }

    private static int sumFunctional(int i, int n) {

        if(i==n)
            return i;
        return i+sumFunctional(i+1,n);
        //TC:O(N)
        //SC:O(N)
    }
}
